package by.tempus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInForm {
    private String URL = "https://tempus.by/";
    private String BUTTON_LOGIN = "//button[@class=\"icons__action icons__action--account j-sidePanel\"]";
    private String HEAD_FORM_TITLE = "//li[contains(@class, 'is-active')]//button[text()='Вход']";

    private WebDriver driver;

    public LogInForm(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.navigate().to(URL);
    }

    public void clickButtonLogIn() {
        driver.findElement(By.xpath(BUTTON_LOGIN)).click();
    }

    public String getHeadFormTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEAD_FORM_TITLE))).getText();
    }
}
