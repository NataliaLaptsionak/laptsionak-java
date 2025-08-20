package by.ncv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private String URL = "https://nsv.by/";
    private String ACCEPT_COOKIE = "//a[@id='paloma_cookie-accept']";
    private String CLOSE_MODAL = "//div[@class='modal_game_width_close']";
    private String PERSONAL_LINK = "//header//a[@data-name='auth']";
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.navigate().to(URL);
    }

    public void clickAcceptCookie() {
        driver.findElement(By.xpath(ACCEPT_COOKIE)).click();
    }

    public void clickCloseModal() {
        driver.findElement(By.xpath(CLOSE_MODAL)).click();
    }
    public void clickPersonalLink() {
        driver.findElement(By.xpath(PERSONAL_LINK)).click();
    }
}
