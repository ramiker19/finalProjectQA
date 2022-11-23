import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testOne {
    @Test
    void testOne() {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\רמירו\\Desktop\\java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register"); // ניווט לאתר
        driver.findElement(By.id("input-firstname")).sendKeys("Rami"); // הכנסת שם משתמש
        driver.findElement(By.id("input-lastname")).sendKeys("Beni"); // הכנסת שם משפחה
        driver.findElement(By.id("input-email")).sendKeys("inay@gmail.com"); // הכנסת אימייל
        driver.findElement(By.id("input-telephone")).sendKeys("123456789"); // הכנסת טלפון
        driver.findElement(By.id("input-password")).sendKeys("12345678"); // הכנסת סיסמא
        driver.findElement(By.id("input-confirm")).sendKeys("12345678"); // הכנסת סיסמא שנית
        driver.findElement(By.name("agree")).click(); // אישור תנאי משתמש
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click(); // המשך







    }
}