package by.itacademy.laptsionak;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование класса Калькулятор")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void initAll() {
        System.out.println("Начало выполнения тестов для CalculatorTest");
        System.out.println("Выполняется метод @BeforeAll: запускается один раз перед всеми тестами.");
    }

    @BeforeEach
    @DisplayName("Инициализация калькулятора перед каждым тестом")
    void setUp() {
        calculator = new Calculator();
        System.out.println("Выполнился метод @BeforeEach: подготовка к новому тесту.");
    }

    @AfterEach
    @DisplayName("Очистка ресурсов после каждого теста")
    void tearDown() {
        calculator = null;
        System.out.println("Выполнился метод @AfterEach: очистка после теста.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Выполняется метод @AfterAll: запускается один раз после всех тестов.");
        System.out.println("Все тесты для CalculatorTest завершены");
    }


    @Test
    @Order(1)
    @DisplayName("1. Проверка сложения двух положительных чисел")
    void testSum_PositiveNumbers() {
        assertEquals(5, calculator.sum(2, 3), "2 + 3 должно быть 5");
    }

    @Test
    @Order(2)
    @DisplayName("2. Проверка вычитания")
    void testSubtract_PositiveNumbers() {
        assertEquals(5, calculator.subtract(10, 5), "10 - 5 должно быть 5");
    }

    @Test
    @Order(3)
    @DisplayName("3. Проверка умножения")
    void testMultiply_PositiveNumbers() {
        assertEquals(15, calculator.multiply(3, 5), "3 * 5 должно быть 15");
    }

    @Test
    @Order(4)
    @DisplayName("4. Проверка успешного деления")
    void testDivide_SuccessfulDivision() {
        assertEquals(2.5, calculator.divide(5, 2), "5 / 2 должно быть 2.5");
    }

    @Test
    @Order(5)
    @DisplayName("5. Проверка аварийной ситуации: деление на ноль")
    void testDivide_byZero_shouldThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }

    @Test
    @Order(6)
    @DisplayName("6. Проверка аварийной ситуации: переполнение при сложении")
    void testSum_shouldThrowExceptionOnOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.sum(Integer.MAX_VALUE, 1);
        });
    }

    @Test
    @Order(7)
    @DisplayName("7. Проверка аварийной ситуации: переполнение при умножении")
    void testMultiply_shouldThrowExceptionOnOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.multiply(Integer.MAX_VALUE, 2);
        });
    }
}
