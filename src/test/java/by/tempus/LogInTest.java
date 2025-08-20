package by.tempus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogInTest extends BaseTest {

    @Test
    public void test1() {
        LogInForm logInForm = new LogInForm(driver);
        logInForm.openSite();
        logInForm.clickButtonLogIn();
        logInForm.getHeadFormTitleText();

        Assertions.assertEquals("Вход", logInForm.getHeadFormTitleText());
        driver.quit();
    }
}
