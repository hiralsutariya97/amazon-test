package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TestSuite extends Utility {

    //Open the url https://www.amazon.co.uk/
    String baseURL = "https://www.amazon.co.uk/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void verifyDellLaptopIsDisplayedAndQuantity() throws InterruptedException{

        // add wait time to enter captcha
        Thread.sleep(10000);
        //accept cookies
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));
        //2. Type "Dell Laptop" in the search box and press enter or click on search.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        //click on search.
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        //3. Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//li[@aria-label='Dell']//i[@class='a-icon a-icon-checkbox']"));
        //4. Verify that the  30 (Maybe different) products are displayed on the page.
        List<WebElement> productCount = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Number of products:" + productCount.size());
        //1.5 . Print all product names in the console.
        List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement names : productNames) {System.out.println("Names of product : " + names.getText());}
        //6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver
        clickOnElement(By.xpath("//span[contains(text(),'XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver')]"));
        // 7. Verify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver
        verifyText("Incorrect Text","Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver",By.xpath("//span[@id='productTitle']"));

    }

    // 5. Close the Browser.
    @After
    public void tearDown(){closeBrowser();}
}
