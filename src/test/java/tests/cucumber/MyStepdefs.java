package tests.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;

/**
 * Класс для описания шагов тестирования
 */
public class MyStepdefs extends Steps {

    /**
     * Метод для перехода на требуемый сайт
     * @param url адрес сайта
     */
    @Given("перейти на сайт '(.*)'")
    public void перейтиНаСайт(String url) throws Exception {
        открытьХром();
        chromeDriver.get(url);
    }

    /**
     * Метод вставляет ключевое слово с поисковую строку и проверяет результаты поиска на наличие ссылки на заданный сайт
     * @param keyWord ключевое слово, по которому выполняется запрос в поисковике
     * @param source сайт, который требуется найти в результатах поиска
     */
    @When("^ищем (.*) на сайте (.*) в результатах поиска$")
    public void ищемВРезультатахПоиска(String keyWord, String source) {
        SearchOnGoogle searchOnGoogle = new SearchOnGoogle(chromeDriver);
        searchOnGoogle.find(keyWord);
        Assert.assertTrue("Статья про " + keyWord + " на сайте " + source + " на странице не найдена",
                searchOnGoogle.getResult().stream().anyMatch(x->x.getText().contains(source)));
    }

    /**
     * Метод завершает работу теста
     */
    @Then("закончить работу")
    public void закончитьРаботу() {
        закрытьХром();
    }
}
