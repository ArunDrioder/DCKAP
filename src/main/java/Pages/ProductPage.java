package Pages;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage extends AbstractComponent
{
    WebDriver driver;

    public ProductPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//button[@aria-haspopup='menu']")
    WebElement openAddProductButtonMenu;

    @FindBy(xpath = "//a[@role='menuitem']")
    WebElement clickToNavAddProductPage;



    public AddProductPage goToAddProductPage()
    {
        waitFoWebElementToAppear(openAddProductButtonMenu);
        openAddProductButtonMenu.click();
        waitFoWebElementToAppear(clickToNavAddProductPage);
        clickToNavAddProductPage.click();

        AddProductPage addProductPage = new AddProductPage(driver);
        return addProductPage;
    }




}
