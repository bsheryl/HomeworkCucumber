package tests.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Класс для поиска на Google
 */
public class SearchOnGoogle {
    protected WebDriver chromeDriver;
    protected WebElement searchField;
    private List<WebElement> result;

    WebDriverWait wait;

    /**
     * Конструктор для создания страницы поиска
     * @param chromeDriver ссылка на драйвер
     */
    public SearchOnGoogle(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.searchField = chromeDriver.findElement(By.xpath("//input[@title='Поиск']"));
        wait = new WebDriverWait(chromeDriver, 40);
    }

    /**
     * Медот для слова с строку поисковика
     * @param word искомое слово
     */
    public void find(String word) {
        searchField.click();
        searchField.sendKeys(word);
        searchField.submit();
    }

    /**
     * Метод для выбора всех результатов поиска на странице
     * @return список всех результатов поиска
     */
    public List<WebElement> getResult() {
        System.out.println();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));
        result = chromeDriver.findElements(By.xpath("//div[@data-sokoban-container]"));
        return result;
    }
}
