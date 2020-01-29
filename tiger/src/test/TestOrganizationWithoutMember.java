package test;

import java.io.IOException;

import org.testng.annotations.Test;

import generics.BaseClass;
import pages.CreatingNewOrganizationPage;
import pages.HomePage;
import pages.OrganizationsPage;

public class TestOrganizationWithoutMember extends BaseClass{
	
		
		
		@Test(groups="regressionTest")
		public void testNewOrganization() throws IOException, InterruptedException
		{
			
		
		     int ran=wlib.generateRandomNumber();
			String memberName=flib.readDataFromExcel( "Sheet1", 1, 3)+ran;
			String orgName=flib.readDataFromExcel( "Sheet1", 1, 0)+ran;
			String phnNum=flib.readDataFromExcel( "Sheet1", 1, 1);
			String emailId=flib.readDataFromExcel( "Sheet1", 1, 2);
			
			
			HomePage hp = new HomePage(driver);
			//navigate to organization page
			OrganizationsPage op = hp.navigateToOrganizationsPage();
			
			//navigate new  organization
					CreatingNewOrganizationPage cnop = op.navigateToCreatingNewOrganizationPage();
					cnop.createNewOrganization(memberName, phnNum, emailId);
					
			//wait for element		
			wlib.waitForElementandclick(hp.getOrganizationLink());
			
}
		
}

