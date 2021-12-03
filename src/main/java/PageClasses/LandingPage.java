package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	@FindBy(xpath = "//*[contains(@class,'moneyicon')]")
	public WebElement moneyLink;

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	public MoneyPage clickOnMoneyLink() {
		logger.log(Status.INFO, "Clicking the money Link, Present in header");
		moneyLink.click();
		logger.log(Status.PASS, "Clicked the money link");
		MoneyPage moneyPage = new MoneyPage(driver, logger);
		PageFactory.initElements(driver, moneyPage);
		System.out.println("return money page object");
		return moneyPage;

	}

	public PortFolioLoginPage clickSingIn() {
		// Perform the Click
		PortFolioLoginPage portFolioLoginPage = new PortFolioLoginPage(driver, logger);
		PageFactory.initElements(driver, portFolioLoginPage);
		return portFolioLoginPage;
	}

}
