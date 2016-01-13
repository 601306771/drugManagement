package test;

import javax.annotation.Resource;  

import net.arnx.jsonic.JSON;

import org.apache.log4j.Logger;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import silver.api.user.biz.userDao;
import silver.api.user.entity.user;
  
//@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:application-context.xml"})  
  
public class TestMyBatis {  
//    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private  userDao  ud= null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        user user = ud.selectByPrimaryKey();  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
//        logger.info(user); 
        System.out.println(user);
    }  
}  
