package Pages;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage extends AbstractComponent {
    WebDriver driver;

    public AddProductPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement saveProductBtn;

    @FindBy(xpath = "//input[@name = 'name']")
    WebElement productName;

    @FindBy(xpath = "//input[contains(@name,'sku')]")
    WebElement sku;

    @FindBy(xpath = "//textarea[@name='shortDescription']")
    WebElement shortDescription;

    @FindBy(xpath = "//iframe[contains(@id, 'tiny-react')]")
    WebElement frameXpath;

    @FindBy(css = "body p")
    WebElement longDescription;

    @FindBy(xpath = "//button[normalize-space()='Add Product']")
    WebElement addProductKitButton;

    @FindBy(xpath = "//input[contains(@title,'Toggle row')]")
    WebElement selectAllProduct;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveProductKitButton;


    public void addBundleProducts(String nameOfProduct, String skuName, String shortDes, String longDes) throws InterruptedException {

        waitFoWebElementToAppear(productName);
        waitForElementToBeClickable(productName);
        productName.sendKeys(nameOfProduct);
        sku.sendKeys(skuName);
        scrollForElementVisibility(shortDescription);
        shortDescription.sendKeys(shortDes);
//        scrollForElementVisibility(frameXpath);
//        waitForFrames(frameXpath);
        driver.switchTo().frame(frameXpath);
        waitFoWebElementToAppear(longDescription);
        longDescription.clear();
        longDescription.sendKeys(longDes);
        driver.switchTo().defaultContent();
        scrollForElementVisibility(addProductKitButton);
        System.out.println("Reached");
        addProductKitButton.click();
        System.out.println("Clicked");
        waitFoWebElementToAppear(selectAllProduct);
        selectAllProduct.click();
        saveProductKitButton.click();
        scrollForElementVisibility(saveProductBtn);

        Thread.sleep(2000);

        saveProductBtn.click();
    }





}
