/**
 * 
 */
package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

/**
 * @author RAMESH
 *
 */
public class RegisterDataProvider {
	
	@DataProvider(name = "register_excel_inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Downloads\\Selenium programs\\Week3 testcase\\MultipleUsersRegister.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}

}
