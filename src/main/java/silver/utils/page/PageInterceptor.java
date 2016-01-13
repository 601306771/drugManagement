/**
 *
 */
package silver.utils.page;

/**
 * 分页用拦截器
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
	MappedStatement.class, Object.class, RowBounds.class,
	ResultHandler.class }) })
public class PageInterceptor implements Interceptor {

    public class BoundSqlSqlSource implements SqlSource {
	BoundSql boundSql;

	public BoundSqlSqlSource(final BoundSql boundSql) {
	    this.boundSql = boundSql;
	}

	@Override
	public BoundSql getBoundSql(final Object parameterObject) {
	    return boundSql;
	}
    }

    @Override
    public Object intercept(final Invocation invocation) throws Throwable {

	// 当前环境 MappedStatement，BoundSql，及sql取得
	final MappedStatement mappedStatement = (MappedStatement) invocation
		.getArgs()[0];
	final Object parameter = invocation.getArgs()[1];
	final BoundSql boundSql = mappedStatement.getBoundSql(parameter);
	final String originalSql = boundSql.getSql().trim();
	final Object parameterObject = boundSql.getParameterObject();

	// Page对象获取，“信使”到达拦截器！
	final Page page = searchPageWithXpath(boundSql.getParameterObject(),
		".", "page", "*/page");

	if (page != null) {
	    // Page对象存在的场合，开始分页处理
	    final String countSql = getCountSql(originalSql);
	    final Connection connection = mappedStatement.getConfiguration()
		    .getEnvironment().getDataSource().getConnection();
	    final PreparedStatement countStmt = connection
		    .prepareStatement(countSql);
	    final BoundSql countBS = copyFromBoundSql(mappedStatement,
		    boundSql, countSql);
	    final DefaultParameterHandler parameterHandler = new DefaultParameterHandler(
		    mappedStatement, parameterObject, countBS);
	    parameterHandler.setParameters(countStmt);
	    final ResultSet rs = countStmt.executeQuery();
	    int totpage = 0;
	    if (rs.next()) {
		totpage = rs.getInt(1);
	    }
	    rs.close();
	    countStmt.close();
	    connection.close();

	    // 分页计算
	    page.setTotalRecord(totpage);

	    // 对原始Sql追加limit
	    final int offset = (page.getPageNo() - 1) * page.getPageSize();
	    final StringBuffer sb = new StringBuffer();
	    sb.append(originalSql).append(" limit ").append(offset).append(",")
		    .append(page.getPageSize());
	    final BoundSql newBoundSql = copyFromBoundSql(mappedStatement,
		    boundSql, sb.toString());
	    final MappedStatement newMs = copyFromMappedStatement(
		    mappedStatement, new BoundSqlSqlSource(newBoundSql));
	    invocation.getArgs()[0] = newMs;
	}
	return invocation.proceed();

    }

    @Override
    public Object plugin(final Object arg0) {
	return Plugin.wrap(arg0, this);
    }

    @Override
    public void setProperties(final Properties arg0) {
    }

    /**
     * 复制BoundSql对象
     */
    private BoundSql copyFromBoundSql(final MappedStatement ms,
	    final BoundSql boundSql, final String sql) {
	final BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,
		boundSql.getParameterMappings(), boundSql.getParameterObject());
	for (final ParameterMapping mapping : boundSql.getParameterMappings()) {
	    final String prop = mapping.getProperty();
	    if (boundSql.hasAdditionalParameter(prop)) {
		newBoundSql.setAdditionalParameter(prop,
			boundSql.getAdditionalParameter(prop));
	    }
	}
	return newBoundSql;
    }

    /**
     * 复制MappedStatement对象
     */
    private MappedStatement copyFromMappedStatement(final MappedStatement ms,
	    final SqlSource newSqlSource) {
	final Builder builder = new Builder(ms.getConfiguration(), ms.getId(),
		newSqlSource, ms.getSqlCommandType());

	builder.resource(ms.getResource());
	builder.fetchSize(ms.getFetchSize());
	builder.statementType(ms.getStatementType());
	builder.keyGenerator(ms.getKeyGenerator());
	builder.keyProperty(ms.getKeyProperty());
	builder.timeout(ms.getTimeout());
	builder.parameterMap(ms.getParameterMap());
	builder.resultMaps(ms.getResultMaps());
	builder.resultSetType(ms.getResultSetType());
	builder.cache(ms.getCache());
	builder.flushCacheRequired(ms.isFlushCacheRequired());
	builder.useCache(ms.isUseCache());

	return builder.build();
    }

    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     */
    private String getCountSql(final String sql) {
	return "SELECT COUNT(*) FROM (" + sql + ") aliasForPage";
    }

    /**
     * 根据给定的xpath查询Page对象
     */
    private Page searchPageWithXpath(final Object o, final String... xpaths) {
	final JXPathContext context = JXPathContext.newContext(o);
	Object result;
	for (final String xpath : xpaths) {
	    try {
		result = context.selectSingleNode(xpath);
	    } catch (final JXPathNotFoundException e) {
		continue;
	    }
	    if (result instanceof Page) {
		return (Page) result;
	    }
	}
	return null;
    }
}