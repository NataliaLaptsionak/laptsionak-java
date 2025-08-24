package by.ncv.pages;

import webDriver.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private String URL = "https://nsv.by/";
    private String ACCEPT_COOKIE = "//a[@id='paloma_cookie-accept']";
    private String CLOSE_MODAL = "//div[@class=\"modal_game_width_close\"]";
    private String PERSONAL_LINK = "//header//a[@data-name='auth']";

    public HomePage() {
    }

    public HomePage openSite() {
        WebDriver.getDriver().navigate().to(URL);
        return this;
    }

    public HomePage clickAcceptCookie() {
        WebDriver.clickElement(ACCEPT_COOKIE); // Используем наш метод
        return this;
    }

    public HomePage clickCloseModal() {
        try {
            WebDriver.clickElement(CLOSE_MODAL);
        } catch (Exception e) {
            System.out.println("Модального окна (баннера) не было, оно не закрывалось.");
        }
        return this;
    }

    public HomePage clickPersonalLink() {
        WebDriver.clickElement(PERSONAL_LINK);
        return this;
    }
}