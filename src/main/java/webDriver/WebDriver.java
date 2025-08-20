package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriver {
    private static org.openqa.selenium.WebDriver driver;
    private static WebDriverWait wait;

    public static org.openqa.selenium.WebDriver getDriver() {
        if(driver==null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quit() {
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
    public static WebElement findElement(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    // Улучшенный метод, который ждет кликабельности элемента
    public static void clickElement(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    // Новый метод для ввода текста, который тоже ждет
    public static void sendKeysToElement(String xpath, String value) {
        WebElement element = findElement(xpath); // Ждем видимости
        element.clear();
        element.sendKeys(value);
    }

    public static String getTextFromElement(String xpath) {
        return findElement(xpath).getText(); // findElement уже содержит ожидание
    }
}