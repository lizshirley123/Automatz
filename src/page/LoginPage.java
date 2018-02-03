package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id="username")
	private WebElement unTB;

	@FindBy(name="pwd")
	private WebElement pwTB;

	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMSG;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickLogin() {
		loginBTN.click();
	}

	public void verifyErrMSG(WebDriver driver) {
		try {
			WebDriverWait wt=new WebDriverWait(driver,10);
			wt.until(ExpectedConditions.visibilityOf(errMSG));
			Reporter.log("Error MSG is dispalyed", true);
		}catch(Exception e) {
			Reporter.log("Error MSG is not Dispalyed",true);
		}
	}
}
