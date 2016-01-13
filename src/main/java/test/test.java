package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import silver.api.newDrugRequest.biz.NewDrugRequestBiz;
import silver.api.newDrugRequest.entity.NewDrugRequestEntity;


public class test {
	 private static NewDrugRequestBiz newDrugRequestBiz ;
	
	
	@Test
	public static void main(String[] args){
		newDrugRequestBiz.selectByStatus("new");
//		return "manageRequest";
	}
	
}
