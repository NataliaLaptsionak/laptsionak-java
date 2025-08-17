package by.tempus;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // driver.get("https://tempus.by/");
        driver.navigate().to("https://tempus.by/");

        String inputLoginXpath = "//button[@class=\"icons__action icons__action--account j-sidePanel\"]";
        By inputLoginByXpath = By.xpath(inputLoginXpath);
        WebElement inputLoginElement = driver.findElement(By.xpath(inputLoginXpath));
        inputLoginElement.click();

        String inputEmailXpath = "//input[@name=\"email\"]";
        By inputEmailByXpath = By.xpath(inputEmailXpath);
        WebElement inputEmailElement = driver.findElement(inputEmailByXpath);
        inputEmailElement.sendKeys("testmail@mail.com");

        String inputPasswordXpath = "//input[@name=\"password\"]";
        By inputPasswordByXpath = By.xpath(inputPasswordXpath);
        WebElement inputPasswordElement = driver.findElement(inputPasswordByXpath);
        inputPasswordElement.sendKeys("Qwerty12345");

        String buttonSubmitXpath = "//button[@class=\"button is-primary\"]";
        By buttonSubmitByXpath = By.xpath(buttonSubmitXpath);
        WebElement buttonSubmitElement = driver.findElement(buttonSubmitByXpath);
        buttonSubmitElement.click();

        String messageXpath = "//div[contains(@class, 'success-popup__text')]";
        By messageByXpath = By.xpath(messageXpath);

        WebElement messageXpathElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageByXpath));

        String actual = messageXpathElement.getText();
        System.out.println("Фактический текст ошибки: " + actual);
        Assertions.assertEquals("Неверные учетные данные или пользователь деактивирован\\заблокирован", actual);
        System.out.println("Тест пройден успешно!");

        driver.quit();
    }
}
