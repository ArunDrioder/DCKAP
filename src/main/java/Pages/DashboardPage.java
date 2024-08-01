package Pages;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends AbstractComponent {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='mb-2'][1]")
    WebElement catalogMenu;

    @FindBy(xpath = "//a[normalize-space()='Products']")
    WebElement productsSubMenu;


    public ProductPage navigateToProductPage()
    {
        waitFoWebElementToAppear(catalogMenu);
        catalogMenu.click();
        productsSubMenu.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;

    }


}
