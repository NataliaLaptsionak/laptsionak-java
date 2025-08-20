package by.shop7745;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Shop7745Page {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By cookieAcceptButton = By.xpath("//button[@id=\"gdprAccept\"]");
    private final By loginIcon = By.xpath("//div[@class=\"svg-icon header-icon__icon--person\"]");
    private final By loginFormTitle = By.xpath("//span[@class=\"modal-layout-header__title\"]");

    public Shop7745Page(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://7745.by/");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
        } catch (Exception e) {
            System.out.println("Окно сookie не было найдено или уже закрыто.");
        }
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon)).click();
    }

    public String getLoginFormTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginFormTitle)).getText();
    }
}
