package by.ncv.pages;

import webDriver.WebDriver;
import org.openqa.selenium.By;

public class CabinetPage {

    private final String HEAD_FORM_TITLE = "//div[@class='form_head']/h2";
    private final String USER_LOGIN_INPUT_NAME = "USER_LOGIN";
    private final String USER_PASSWORD_INPUT_NAME = "USER_PASSWORD";
    private final String BUTTON_LOGIN_NAME = "Login";
    private final String USER_LOGIN_POPUP_ERROR_XPATH = "//label[@id='USER_LOGIN_POPUP-error']";
    private final String USER_PASSWORD_POPUP_ERROR_XPATH = "//label[@id='USER_PASSWORD_POPUP-error']";
    private final String USER_PASSWORD_POPUP_ERROR_NUMBER_OF_SYMBOLS = "//label[normalize-space()='Минимум 6 символов']";
    private final String USER_CREDENTIALS_POPUP_ERROR_XPATH = "//div[@class='alert alert-danger']/p[text()='Неверный логин или пароль']";

    public CabinetPage() {
    }

    public String getHeadFormTitleText() {
        return WebDriver.getTextFromElement(HEAD_FORM_TITLE);
    }

    public void sendKeysLogin(String login) {
        WebDriver.getDriver().findElement(By.name(USER_LOGIN_INPUT_NAME)).sendKeys(login);
    }

    public void sendKeysPassword(String password) {
        WebDriver.getDriver().findElement(By.name(USER_PASSWORD_INPUT_NAME)).sendKeys(password);
    }

    public void clickButtonLogin() {
        WebDriver.getDriver().findElement(By.name(BUTTON_LOGIN_NAME)).click();
    }

    public String getUserLoginPopupErrorText() {
        return WebDriver.getTextFromElement(USER_LOGIN_POPUP_ERROR_XPATH);
    }

    public String getUserPasswordPopupErrorText() {
        return WebDriver.getTextFromElement(USER_PASSWORD_POPUP_ERROR_XPATH);
    }

    public String getUserPasswordPopupErrorNumberOfSymbols() {
        return WebDriver.getTextFromElement(USER_PASSWORD_POPUP_ERROR_NUMBER_OF_SYMBOLS);
    }

    public String getUserCredentialsPopupErrorText() {
        return WebDriver.getTextFromElement(USER_CREDENTIALS_POPUP_ERROR_XPATH);
    }
}
