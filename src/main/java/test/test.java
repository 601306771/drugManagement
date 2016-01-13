package test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import silver.api.newDrugRequest.biz.NewDrugRequestBiz;
import silver.api.newDrugRequest.entity.NewDrugRequestEntity;
import silver.api.user.biz.UsersBiz;
import silver.api.user.entity.Users;


public class test {
	
	
	
	
	public static void main(String[] args){
		
	    UsersBiz  ub= null;  
	    	Users record = new Users(1,"admin","admin",1,"管理员阿花","这是系统的管理员啊");
	    	if(record!=null){
	        int result = ub.insertSelective(record);
	        // System.out.println(user.getUserName());  
	        // logger.info("值："+user.getUserName());  
	        System.out.println(result);
	    	}
	    	
	}
	
}
