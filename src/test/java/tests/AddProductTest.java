package tests;

import Pages.AddProductPage;
import Pages.DashboardPage;
import Pages.ProductPage;
import TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AddProductTest extends BaseTest
{
    @Test (dataProvider = "getProductData")
    public void addProduct(HashMap<String, String> input) throws InterruptedException {
        DashboardPage dashboardPage = landingPage.loginToApp(input.get("email"),input.get("password"));
        ProductPage productPage = dashboardPage.navigateToProductPage();
        AddProductPage addProductPage = productPage.goToAddProductPage();
        addProductPage.addBundleProducts(input.get("nameOfProduct"),input.get("skuName"),input.get("shortDes"),input.get("longDes"));


    }

    @DataProvider
    public Object[][] getProductData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//productData.json");
        return new Object[][]{{data.getFirst()}};


    }




}
