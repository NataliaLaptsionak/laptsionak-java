package by.ncv;

import by.ncv.pages.CabinetPage;
import by.ncv.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CabinetTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        new HomePage()
                .openSite()
                .clickCloseModal()
                .clickAcceptCookie()
                .clickPersonalLink();
    }

    @Test
    @DisplayName("Проверка заголовка 'Личный кабинет' в форме входа")
    public void test1() {
        CabinetPage cabinetPage = new CabinetPage();
        Assertions.assertEquals("Личный кабинет", cabinetPage.getHeadFormTitleText());
    }

    @Test
    @DisplayName("Проверка ошибок валидации при отправке пустой формы")
    public void test2() {
        CabinetPage cabinetPage = new CabinetPage();
        cabinetPage.clickButtonLogin();
        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserLoginPopupErrorText());
        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserPasswordPopupErrorText());
    }

    @Test
    @DisplayName("Проверка ошибки валидации при пустом поле пароля")
    public void test3() {
        CabinetPage cabinetPage = new CabinetPage();
        cabinetPage.sendKeysLogin("test_login");
        cabinetPage.clickButtonLogin();
        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserPasswordPopupErrorText());
    }

    @Test
    @DisplayName("Проверка ошибки валидации при пустом поле логина")
    public void test4() {
        CabinetPage cabinetPage = new CabinetPage();
        cabinetPage.sendKeysPassword("test_password");
        cabinetPage.clickButtonLogin();
        Assertions.assertEquals("Заполните это поле", cabinetPage.getUserLoginPopupErrorText());
    }

    @Test
    @DisplayName("Проверка ошибки валидации при вводе в поле Пароль менее 6 символов")
    public void test5() {
        CabinetPage cabinetPage = new CabinetPage();
        cabinetPage.sendKeysLogin("test_login");
        cabinetPage.sendKeysPassword("test");
        cabinetPage.clickButtonLogin();
        Assertions.assertEquals("Минимум 6 символов", cabinetPage.getUserPasswordPopupErrorNumberOfSymbols());
    }

    @Test
    @DisplayName("Проверка отображения ошибки при вводе неверных логина и пароля")
    public void test6() {
        CabinetPage cabinetPage = new CabinetPage();
        cabinetPage.sendKeysLogin("test_login");
        cabinetPage.sendKeysPassword("test_password");
        cabinetPage.clickButtonLogin();
        Assertions.assertEquals("Неверный логин или пароль", cabinetPage.getUserCredentialsPopupErrorText());
    }
}