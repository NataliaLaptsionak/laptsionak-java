package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebDriver {
    private static org.openqa.selenium.WebDriver driver;
    private static WebDriverWait wait;

    public static org.openqa.selenium.WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebElement findElement(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void clickElement(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public static void sendKeysToElement(String xpath, String value) {
        WebElement element = findElement(xpath);
        element.clear();
        element.sendKeys(value);
    }

    public static String getTextFromElement(String xpath) {
        return findElement(xpath).getText();
    }


    public static List<WebElement> findElements(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }


    public static void pressEnterOnElement(String xpath) {
        findElement(xpath).sendKeys(Keys.ENTER);
    }
}