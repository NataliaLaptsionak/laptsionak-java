package by.shop7745;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shop7745Test {
    private WebDriver driver;
    private Shop7745Page shop7745Page;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        shop7745Page = new Shop7745Page(driver);
    }

    @Test
    public void testOpenLoginForm() {
        shop7745Page.open();
        shop7745Page.clickLogin();
        String actualTitle = shop7745Page.getLoginFormTitle();
        Assertions.assertEquals("Войти", actualTitle, "Заголовок формы входа не соответствует ожидаемому");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
