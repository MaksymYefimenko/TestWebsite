package TestWebsite;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebsite {

        ChromeDriver driver;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "/Users/maksymyefimenko/Desktop/chromedriver");
            driver = new ChromeDriver();
        }

        @Test
        public void serchTest() {
            driver.get("http://demo.guru99.com/test/newtours/");

            WebElement searchFieled = driver.findElement(By.name ("<input type=\"text\" name=\"userName\" size=\"10\">"));
            searchFieled.sendKeys("TestWebsite"+ Keys.ENTER);

            WebElement searchFieled1 = driver.findElement(By.name ("<input type=\"password\" name=\"password\" size=\"10\" class=\"\">"));
            searchFieled1.sendKeys("TestWebsite"+ Keys.ENTER);

            WebElement firstResult = new WebDriverWait(driver, 5).until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//span[tex='body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(4) > td:nth-child(2) > div > input[type=submit]']")
                    ));

            firstResult.click();
            String actual=driver.findElement(By.className("getting-started")).getText();
            String expected = "Getting Started";
            Assert.assertEquals(actual,expected);
            driver.findElement(By.name("<b> Thank you for Loggin. </b>"));
        }
        @AfterClass
        public void tearDown() {

            driver.quit();
        }
    }