package by.ncv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CabinetPage {

    private final String HEAD_FORM_TITLE = "//div[@class='form_head']/h2";
    private final String USER_LOGIN_INPUT_NAME = "USER_LOGIN";
    private final String USER_PASSWORD_INPUT_NAME = "USER_PASSWORD";
    private final String BUTTON_LOGIN_NAME = "Login";

    private final String USER_LOGIN_POPUP_ERROR_XPATH = "//label[@id='USER_LOGIN_POPUP-error']";
    private final String USER_PASSWORD_POPUP_ERROR_XPATH = "//label[@id='USER_PASSWORD_POPUP-error']";

    private WebDriver driver;

    public CabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeadFormTitleText() {
        return driver.findElement(By.xpath(HEAD_FORM_TITLE)).getText();
    }

    public void sendKeysLogin(String login) {
        driver.findElement(By.name(USER_LOGIN_INPUT_NAME)).sendKeys(login);
    }

    public void sendKeysPassword(String password) {
        driver.findElement(By.name(USER_PASSWORD_INPUT_NAME)).sendKeys(password);
    }

    public void clickButtonLogin() {
        driver.findElement(By.name(BUTTON_LOGIN_NAME)).click();
    }

    public String getUserLoginPopupErrorText() {
        return driver.findElement(By.xpath(USER_LOGIN_POPUP_ERROR_XPATH)).getText();
    }

    public String getUserPasswordPopupErrorText() {
        return driver.findElement(By.xpath(USER_PASSWORD_POPUP_ERROR_XPATH)).getText();
    }
}