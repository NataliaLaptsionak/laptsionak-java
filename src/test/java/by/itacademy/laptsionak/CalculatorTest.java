package by.itacademy.laptsionak;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование класса Калькулятор")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void initAll() {
        System.out.println("Начало выполнения тестов для CalculatorTest");
    }

    @BeforeEach
    @DisplayName("Инициализация калькулятора перед каждым тестом")
    void setUp() {
        calculator = new Calculator();
        System.out.println("-> @BeforeEach: подготовка к новому тесту.");
    }


    @AfterEach
    @DisplayName("Очистка ресурсов после каждого теста")
    void tearDown() {
        calculator = null;
        System.out.println("<- @AfterEach: очистка после теста.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Все тесты для CalculatorTest завершены");
    }

    @Order(1)
    @DisplayName("1. Проверка сложения")
    @ParameterizedTest(name = "{index}: {0} + {1} = {2}")
    @CsvSource({
            "2, 3, 5",
            "-1, 1, 0",
            "0, 0, 0",
            "-5, -10, -15",
            "100, 200, 300"
    })
    void sum_shouldReturnCorrectResult(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.sum(a, b));
    }

    @Order(2)
    @DisplayName("2. Проверка вычитания")
    @ParameterizedTest(name = "{index}: {0} - {1} = {2}")
    @CsvSource({
            "10, 5, 5",
            "5, 10, -5",
            "0, 0, 0",
            "-5, -5, 0",
            "10, -5, 15"
    })
    void subtract_shouldReturnCorrectResult(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.subtract(a, b));
    }

    @Order(3)
    @DisplayName("3. Проверка умножения")
    @ParameterizedTest(name = "{index}: {0} * {1} = {2}")
    @CsvSource({
            "3, 5, 15",
            "-3, 5, -15",
            "0, 100, 0",
            "-5, -5, 25"
    })
    void multiply_shouldReturnCorrectResult(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.multiply(a, b));
    }

    @Order(4)
    @DisplayName("4. Проверка успешного деления")
    @ParameterizedTest(name = "{index}: {0} / {1} = {2}")
    @CsvSource({
            "5, 2, 2.5",
            "10, 4, 2.5",
            "-9, 3, -3.0",
            "0, 5, 0.0"
    })
    void divide_shouldReturnCorrectResult(double a, double b, double expectedResult) {
        assertEquals(expectedResult, calculator.divide(a, b));
    }

    @Test
    @Order(5)
    @DisplayName("5. Проверка деления на ноль")
    void divide_byZero_shouldThrowArithmeticException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Order(6)
    @DisplayName("6. Проверка переполнения при арифметических операциях")
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("overflowArguments")
    void operation_shouldThrowArithmeticExceptionOnOverflow(String testName, Runnable operation) {
        assertThrows(ArithmeticException.class, operation::run);
    }

    private static Stream<Arguments> overflowArguments() {
        return Stream.of(
                Arguments.of("Сложение Integer.MAX_VALUE + 1", (Runnable) () -> new Calculator().sum(Integer.MAX_VALUE, 1)),
                Arguments.of("Сложение Integer.MIN_VALUE - 1", (Runnable) () -> new Calculator().sum(Integer.MIN_VALUE, -1)),
                Arguments.of("Вычитание Integer.MIN_VALUE - 1", (Runnable) () -> new Calculator().subtract(Integer.MIN_VALUE, 1)),
                Arguments.of("Умножение Integer.MAX_VALUE * 2", (Runnable) () -> new Calculator().multiply(Integer.MAX_VALUE, 2))
        );
    }
}
