package by.tempus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://tempus.by/");
    }
    @Test
    public void test1() {
        By inputLoginByXpath = By.xpath(LoginPage.INPUT_LOGIN);
        WebElement inputLoginElement = driver.findElement(By.xpath(LoginPage.INPUT_LOGIN));
        inputLoginElement.click();

        By inputEmailByXpath = By.xpath(LoginPage.INPUT_EMAIL);
        WebElement inputEmailElement = driver.findElement(By.xpath(LoginPage.INPUT_EMAIL));
        inputEmailElement.sendKeys("testmail@mail.com");

        By inputPasswordByXpath = By.xpath(LoginPage.INPUT_PASSWORD);
        WebElement inputPasswordElement = driver.findElement(By.xpath(LoginPage.INPUT_PASSWORD));
        inputPasswordElement.sendKeys("Qwerty12345");

        By buttonSubmitByXpath = By.xpath(LoginPage.BUTTON_SUBMIT);
        WebElement buttonSubmitElement = driver.findElement(By.xpath(LoginPage.BUTTON_SUBMIT));
        buttonSubmitElement.click();

        By messageByXpath = By.xpath(LoginPage.MESSAGE_PATH);
        WebElement messageXpathElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageByXpath));

        String actual = messageXpathElement.getText();
        System.out.println("Фактический текст ошибки: " + actual);
        Assertions.assertEquals("Неверные учетные данные или пользователь деактивирован\\заблокирован", actual);

        System.out.println("Тест пройден успешно!");

    }
    @AfterEach
        public void finish() {
        driver.quit();
    }
}
