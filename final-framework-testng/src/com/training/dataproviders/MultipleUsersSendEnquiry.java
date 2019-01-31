package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class MultipleUsersSendEnquiry {
	
	@DataProvider(name = "MultipleUsersSendEnquiry_excel_inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Downloads\\Selenium programs\\Week3 testcase\\MultipleUsersSendEnquiry.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
		
	}

}
