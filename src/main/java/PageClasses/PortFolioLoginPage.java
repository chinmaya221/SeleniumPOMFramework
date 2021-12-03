package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;
import BaseClasses.TopMenuClass;

public class PortFolioLoginPage extends PageBaseClass {

	public TopMenuClass topmenu;

	public PortFolioLoginPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}

	@FindBy(id = "useremail")
	public WebElement useremail_TextBox;

	@FindBy(id = "emailsubmit")
	public WebElement emailSubmit_button;

	@FindBy(id = "userpass")
	public WebElement password_TextBox;

	@FindBy(id = "loginsubmit")
	public WebElement submitLogin_button;

	public MyPortfolioPage doLogin(String userName, String password) {

		useremail_TextBox.sendKeys(userName);
		logger.log(Status.PASS, "Entered the UserName : " + userName);
		waitForPageLoad();
		logger.log(Status.PASS, "Clicked the UserName Submit Buttton");
		password_TextBox.sendKeys(password);
		logger.log(Status.PASS, "Entered the Password : " + password);
		submitLogin_button.click();
		logger.log(Status.PASS, "Clicked the Submit Login Button");
		waitForPageLoad();
		String currentPageTitle = driver.getTitle();
		System.out.println(currentPageTitle);
		if (currentPageTitle.equals("Indian stock markets: Login to Portfolio")) {
			reportFail("Login is failed on Portfolio Login Page");
			Assert.fail("Login Failed");
		}
		MyPortfolioPage myportFolioPage = new MyPortfolioPage(driver, logger);
		PageFactory.initElements(driver, myportFolioPage);
		return myportFolioPage;
	}

	public void enterUser(String userName) {
		useremail_TextBox.sendKeys(userName);
		logger.log(Status.PASS, "Entered the UserName : " + userName);
	}

	public void submitUserName() {
		emailSubmit_button.click();
		logger.log(Status.PASS, "Clicked the UserName Submit Buttton");
	}

	public void enterPassword(String password) {
		password_TextBox.sendKeys(password);
		logger.log(Status.PASS, "Entered the Password : " + password);
	}

	public MyPortfolioPage submitLogin() {
		submitLogin_button.click();
		logger.log(Status.PASS, "Cliecked the Submit Login Button");
		MyPortfolioPage myportFolioPage = new MyPortfolioPage(driver, logger);
		PageFactory.initElements(driver, myportFolioPage);
		return myportFolioPage;
	}

	public void verifyPasswordField() {
		veriyElementIsDisplayed(password_TextBox);
	}

}
