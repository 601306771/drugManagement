package silver.utils.page;

/**
 * 封装分页数据
 */
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Page {

    public static String DEFAULT_PAGESIZE = "10";
    private static final Logger logger = LoggerFactory.getLogger(Page.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static Page newBuilder(final int pageNo, final int pageSize,
	    final String url) {
	final Page page = new Page();
	page.setPageNo(pageNo);
	page.setPageSize(pageSize);
	page.setSearchUrl(url);
	return page;
    }

    private int pageNo;          // 当前页码
    private String pageNoDisp;       // 可以显示的页号(分隔符"|"，总页数变更时更新)
    private int pageSize;        // 每页行数
    private Map<String, List<String>> paramLists;  // 数组查询条件
    private Map<String, String> params;  // 查询条件
    private String searchUrl;      // Url地址
    private int totalPage;        // 总页数

    private int totalRecord;      // 总记录数

    private Page() {
	pageNo = 1;
	pageSize = Integer.valueOf(DEFAULT_PAGESIZE);
	totalRecord = 0;
	totalPage = 0;
	params = Maps.newHashMap();
	paramLists = Maps.newHashMap();
	searchUrl = "";
	pageNoDisp = "";
    }

    public int getPageNo() {
	return pageNo;
    }

    public String getPageNoDisp() {
	return pageNoDisp;
    }

    public int getPageSize() {
	return pageSize;
    }

    /**
     * 查询条件转JSON
     */
    public String getParaJson() {
	final Map<String, Object> map = Maps.newHashMap();
	for (final String key : params.keySet()) {
	    if (params.get(key) != null) {
		map.put(key, params.get(key));
	    }
	}
	String json = "";
	try {
	    json = mapper.writeValueAsString(map);
	} catch (final Exception e) {
	    logger.error("转换JSON失败", params, e);
	}
	return json;
    }

    /**
     * 数组查询条件转JSON
     */
    public String getParaListJson() {
	final Map<String, Object> map = Maps.newHashMap();
	for (final String key : paramLists.keySet()) {
	    final List<String> lists = paramLists.get(key);
	    if (lists != null && lists.size() > 0) {
		map.put(key, lists);
	    }
	}
	String json = "";
	try {
	    json = mapper.writeValueAsString(map);
	} catch (final Exception e) {
	    logger.error("转换JSON失败", params, e);
	}
	return json;
    }

    public Map<String, List<String>> getParamLists() {
	return paramLists;
    }

    public Map<String, String> getParams() {
	return params;
    }

    public String getSearchUrl() {
	return searchUrl;
    }

    public int getTotalPage() {
	return totalPage;
    }

    public int getTotalRecord() {
	return totalRecord;
    }

    public void setPageNo(final int pageNo) {
	this.pageNo = pageNo;
    }

    public void setPageNoDisp(final String pageNoDisp) {
	this.pageNoDisp = pageNoDisp;
    }

    public void setPageSize(final int pageSize) {
	this.pageSize = pageSize;
    }

    public void setParamLists(final Map<String, List<String>> paramLists) {
	this.paramLists = paramLists;
    }

    public void setParams(final Map<String, String> params) {
	this.params = params;
    }

    public void setSearchUrl(final String searchUrl) {
	this.searchUrl = searchUrl;
    }

    public void setTotalPage(final int totalPage) {
	this.totalPage = totalPage;
    }

    public void setTotalRecord(final int totalRecord) {
	this.totalRecord = totalRecord;
	refreshPage();
    }

    /**
     * 计算页号显示样式
     * 这里实现以下的分页样式("[]"代表当前页号)，可根据项目需求调整
     * &nbsp;&nbsp; *&nbsp;&nbsp; [1],2,3,4,5,6,7,8..12,13
     * &nbsp;&nbsp; *&nbsp;&nbsp; 1,2..5,6,[7],8,9..12,13
     * &nbsp;&nbsp; *&nbsp;&nbsp; 1,2..6,7,8,9,10,11,12,[13]
     */
    private String computeDisplayStyleAndPage() {
	final List<Integer> pageDisplays = Lists.newArrayList();
	if (totalPage <= 11) {
	    for (int i = 1; i <= totalPage; i++) {
		pageDisplays.add(i);
	    }
	} else if (pageNo < 7) {
	    for (int i = 1; i <= 8; i++) {
		pageDisplays.add(i);
	    }
	    pageDisplays.add(0);// 0 表示 省略部分(下同)
	    pageDisplays.add(totalPage - 1);
	    pageDisplays.add(totalPage);
	} else if (pageNo > totalPage - 6) {
	    pageDisplays.add(1);
	    pageDisplays.add(2);
	    pageDisplays.add(0);
	    for (int i = totalPage - 7; i <= totalPage; i++) {
		pageDisplays.add(i);
	    }
	} else {
	    pageDisplays.add(1);
	    pageDisplays.add(2);
	    pageDisplays.add(0);
	    for (int i = pageNo - 2; i <= pageNo + 2; i++) {
		pageDisplays.add(i);
	    }
	    pageDisplays.add(0);
	    pageDisplays.add(totalPage - 1);
	    pageDisplays.add(totalPage);
	}
	return Joiner.on("|").join(pageDisplays.toArray());
    }

    /**
     * 总件数变化时，更新总页数并计算显示样式
     */
    private void refreshPage() {
	// 总页数计算
	totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
		: (totalRecord / pageSize + 1);
	// 防止超出最末页（浏览途中数据被删除的情况）
	if (pageNo > totalPage && totalPage != 0) {
	    pageNo = totalPage;
	}
	pageNoDisp = computeDisplayStyleAndPage();
    }
}