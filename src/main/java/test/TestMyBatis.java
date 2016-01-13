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

import silver.api.user.biz.UsersBiz;
import silver.api.user.biz.userDao;
import silver.api.user.entity.Users;
import silver.api.user.entity.user;
  
@ContextConfiguration(locations = {"classpath:application-context.xml"})  
  
public class TestMyBatis {  
 
    @Resource  
    private  UsersBiz  ub= null;  
  

  
    @Test  
    public void test1() {  
    	Users record = new Users(1,"admin","admin",1,"管理员阿花","这是系统的管理员啊");
        int result = ub.insertSelective(record);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
//        logger.info(user); 
        System.out.println(result);
    }  
}  
