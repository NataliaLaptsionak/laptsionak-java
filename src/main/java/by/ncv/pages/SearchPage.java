package by.ncv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private final String INPUT_SEARCH = "//input[@id='title-search-input_fixed']";
    private final String BUTTON_SEARCH = "//div[@class='col-md-4 search_wrap']//button[@id='subserch']";
    private final String TITLE_FULL_NAME_SEARCH_RESULT = "//table[@id='bx_3966226736_550471']//span[@itemprop='name']";
    private final String TITLE_PARTIAL_NAME_SEARCH_RESULT = "//div[@class='desc_name']/a/span";
    private final String TITLE_NO_RESULTS = "//div[@class='middle']";

    public void sendKeysSearch(String word) {
        WebDriver.sendKeysToElement(INPUT_SEARCH, word);
    }

    public void startSearch() {
        WebDriver.clickElement(BUTTON_SEARCH);
    }

    public String getSearchResultFirstItemTitleText() {
        return WebDriver.getTextFromElement(TITLE_FULL_NAME_SEARCH_RESULT);
    }

    public List<String> getSearchResultItemsTitleText() {
        List<WebElement> elements = WebDriver.getDriver().findElements(By.xpath(TITLE_PARTIAL_NAME_SEARCH_RESULT));
        List<String> titles = new ArrayList<>();
        for (WebElement element : elements) {
            titles.add(element.getText());
        }
        return titles;
    }

    public String getNoResultsMsg() {
        return WebDriver.getTextFromElement(TITLE_NO_RESULTS);
    }
}
