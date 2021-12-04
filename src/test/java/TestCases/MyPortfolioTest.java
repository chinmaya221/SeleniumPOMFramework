package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import BaseClasses.PageBaseClass;
import BaseClasses.TopMenuClass;
import PageClasses.LandingPage;
import PageClasses.MoneyPage;
import PageClasses.MyPortfolioPage;
import PageClasses.PortFolioLoginPage;
import Utilities.TestDataProvider;

public class MyPortfolioTest extends BaseTest{
	
	LandingPage landingPage;
	MoneyPage moneyPage;
	PortFolioLoginPage portFolioLoginPage;
	MyPortfolioPage myPortfolioPage;
	TopMenuClass topMenu;
	
	
	@Test(dataProvider = "getOpenPortfolioTestData")
	public void openPortfolio(Hashtable<String, String> dataTable) {
		
		logger = report.createTest("Login Rediff Portfolio : "+ "openPortfolio");
		
		
		PageBaseClass page = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, page);
		landingPage = page.OpenApplication();
		moneyPage = landingPage.clickOnMoneyLink();
		portFolioLoginPage = moneyPage.clickOnMoneyPageSignIn();
		myPortfolioPage = portFolioLoginPage.doLogin(dataTable.get("username"), dataTable.get("password"));
		myPortfolioPage.verifyMoneyBiz();
		myPortfolioPage.getTitle(dataTable.get("pagetitle"));
		topMenu = myPortfolioPage.gettopMenu();
		topMenu.singOutApplication();
		
		
	}
	
	@DataProvider
	public Object[][] getOpenPortfolioTestData(){
		
		return TestDataProvider.getTestData("TestFile.xlsx", "RedlifLoginTest", "openPortfolio");
	}
	
	@Test
	public void NewTest() {
		System.out.println("This is just a new test");
	}
	

}
