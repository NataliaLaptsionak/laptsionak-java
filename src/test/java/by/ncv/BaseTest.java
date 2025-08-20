package by.ncv;

import webDriver.WebDriver;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    protected org.openqa.selenium.WebDriver driver;

    @AfterEach
    public void tearDown() {
        WebDriver.quit();
    }
}
