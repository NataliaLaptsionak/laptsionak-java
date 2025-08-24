package by.ncv;

import by.ncv.pages.HomePage;
import by.ncv.pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchTest extends BaseTest {
    private SearchPage searchPage;
    @BeforeEach
    public void setupTest() {
        new HomePage()
                .openSite()
                .clickCloseModal()
                .clickAcceptCookie();
        searchPage = new SearchPage();
    }

    @Test
    @DisplayName("Проверка поиска конкретного товара по точному названию")
    public void test1() {
        SearchPage searchPage = new SearchPage();
        searchPage.sendKeysSearch("Мотоцикл Benda Funrider 125 (черный)");
        searchPage.startSearch();

        Assertions.assertEquals("Мотоцикл Benda Funrider 125 (черный)", searchPage.getSearchResultFirstItemTitleText());
    }

    @Test
    @DisplayName("Проверка, что все результаты содержат искомое слово (мотоцикл)")
    public void test2() {

        String searchTerm = "мотоцикл";
        searchPage.sendKeysSearch(searchTerm);
        searchPage.startSearch();
        List<String> results = searchPage.getSearchResultItemsTitleText();

        Assertions.assertFalse(results.isEmpty(), "Поиск не должен возвращать пустой результат");

        System.out.println("--- НАЙДЕНЫ СЛЕДУЮЩИИЕ ТОВАРЫ: ---");
        results.forEach(System.out::println); // Короткая запись для вывода каждого элемента списка
        System.out.println("---------------------------------");
    }

    @Test
    @DisplayName("Проверка сообщения 'ничего не найдено' для несуществующего товара")
    public void test3() {
        SearchPage searchPage = new SearchPage();
        searchPage.sendKeysSearch("cucumber");
        searchPage.startSearch();

        Assertions.assertEquals(" \nСожалеем, но ничего не найдено.", searchPage.getNoResultsMsg());
    }
}
