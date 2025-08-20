package by.ncv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabinetTest extends BaseTest {

    @BeforeEach
    public void openHomePageClickAcceptCookieClickPersonalLink() {
        HomePage homePage = new HomePage(driver);
        homePage.openSite();
        homePage.clickAcceptCookie();
        homePage.clickPersonalLink();
    }

    @Test
    public void test1() {
        CabinetPage cabinetPage = new CabinetPage(driver);

        Assertions.assertEquals("Личный кабинет", cabinetPage.getHeadFormTitleText());
    }

    @Test
    public void test2() {
        CabinetPage cabinetPage = new CabinetPage(driver);
        cabinetPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserLoginPopupErrorText());
        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserPasswordPopupErrorText());
    }


    @Test
    public void test3() {
        CabinetPage cabinetPage = new CabinetPage(driver);
        cabinetPage.sendKeysLogin("test_login");
        cabinetPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserPasswordPopupErrorText());
    }

    @Test
    public void test4() {
        CabinetPage cabinetPage = new CabinetPage(driver);
        cabinetPage.sendKeysPassword("test_password");
        cabinetPage.clickButtonLogin();

        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserLoginPopupErrorText());
    }
}
