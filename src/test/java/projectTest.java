import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class projectTest {
   public WebDriver driver = null;
    @BeforeEach
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\רמירו\\Desktop\\java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

        @Test
        public void registerTest () {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\רמירו\\Desktop\\java\\chromedriver.exe");
//            WebDriver driver = new ChromeDriver();
            driver.get("http://tutorialsninja.com/demo/index.php?route=account/register"); // navigate to the website
            driver.findElement(By.id("input-firstname")).sendKeys("Rami"); // inserting username
            driver.findElement(By.id("input-lastname")).sendKeys("Beni"); // inserting lastname
            driver.findElement(By.id("input-email")).sendKeys("inai123@gmail.com"); // inserting e-mail
            driver.findElement(By.id("input-telephone")).sendKeys("123456789"); // inserting phone-number
            driver.findElement(By.id("input-password")).sendKeys("12345678"); // inserting password
            driver.findElement(By.id("input-confirm")).sendKeys("12345678"); // re-inserting password
            driver.findElement(By.name("agree")).click(); // אישור תנאי משתמש
            driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click(); // click on continue
            String urlTest = driver.getCurrentUrl(); // setting variable of the current url
            Assertions.assertTrue(urlTest == "http://tutorialsninja.com/demo/index.php?route=account/success");// checking if the current url is the same as the url in the task

        }


        @Test
        void enteryTest () {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\רמירו\\Desktop\\java\\chromedriver.exe");
//            WebDriver driver = new ChromeDriver();
            driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");//navigate to the website
            driver.findElement(By.id("input-email")).sendKeys("inai123@gmail.com");//inserting correct e-mail
            driver.findElement(By.id("input-password")).sendKeys("12345678");//inserting correct password
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();//click on entry button
            String entryCheck = driver.getCurrentUrl();//setting variable of the current url
            Assertions.assertTrue(entryCheck == "http://tutorialsninja.com/demo/index.php?route=account/account");//checking if the current url is the same as the url in the task
        }


        @Test
        void addToCart () {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\רמירו\\Desktop\\java\\chromedriver.exe");
//            WebDriver driver = new ChromeDriver();
            driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");// navigate to the first product website
            driver.findElement(By.id("button-cart")).click();// adding the product to the cart
            driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=33");// navigate to the second product website
            driver.findElement(By.id("button-cart")).click();// adding the product to the cart
            driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();// checking the cart
            driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();//advancing to checkout
            String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[4]/td[2]")).getText();//setting variable of the total amout of the products
            Assertions.assertEquals(total , "$844.00");//checking if the total amount is the same as the total in the task






        }
        @Test
        void reviewOnProduct () throws InterruptedException {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\רמירו\\Desktop\\java\\chromedriver.exe");
//           WebDriver driver = new ChromeDriver();
            driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");// navigate to the website
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[3]/a")).click();//clicking on "reviews"
            driver.findElement(By.id("input-name")).sendKeys("Rami ");// adding firstname to the review
            String review = "the macbook is a grate computer it runs the apps fast, the color is amazing the buttons are big and nice.";//setting a variable of the review
            driver.findElement(By.xpath("//*[@id=\"input-review\"]")).sendKeys(review);// adding the review to the text box
            List<WebElement> checkboxList = driver.findElements(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input"));// listing all the rating checkboxes
            checkboxList.get(2).click();// choosing the third checkbox
            driver.findElement(By.id("button-review")).click();//clicking on continue
            List<WebElement> thankYouNotice = driver.findElements(By.xpath("//*[@id=\"form-review\"]/div[2]"));//listing the confirmation text boxes
            Assertions.assertTrue(thankYouNotice.size()>0);//checking if there is a confirmation on the review


        }
    }




