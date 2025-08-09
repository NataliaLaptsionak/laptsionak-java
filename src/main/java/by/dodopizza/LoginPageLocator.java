package by.dodopizza;

public class LoginPageLocator {

    public static final String HEADER_TITLE = "//h1[text()='Укажите телефон']";

    public static final String LABEL_PHONE_NUMBER = "//label[text()='Номер телефона']";

    public static final String INPUT_PHONE_NUMBER = "//input[@data-testid='phone-input']";

    public static final String BUTTON_SEND_CODE = "//button[.//span[text()='Выслать код']]";

    public static final String BUTTON_CLOSE_MODAL = "//button[@aria-label='Закрыть']";
}
