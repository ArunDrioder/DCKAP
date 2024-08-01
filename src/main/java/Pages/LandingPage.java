package Pages;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent
{
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='email']")

    WebElement userEmail;

    @FindBy(xpath = "//button[contains(.,'Continue with email')]")
    WebElement continueButton;

    @FindBy(xpath = "//input[@name='password']")
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'items-center flex')]")
    WebElement chooseDemoAccount;


    public void goTo()
    {
        driver.get("https://accounts.enceros.com/");
    }




    public DashboardPage loginToApp(String loginEmail, String loginPassword)
    {
        userEmail.sendKeys(loginEmail);
        continueButton.click();
        waitFoWebElementToAppear(userPassword);
        userPassword.sendKeys(loginPassword);
        loginBtn.click();
        waitFoWebElementToAppear(chooseDemoAccount);
        chooseDemoAccount.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        return dashboardPage ;
    }



}
