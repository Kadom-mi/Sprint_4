package pageObjects;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;

    // Кнопка "Да все привыкли". Cookie
    private final By cookieAcceptButton = By.xpath(".//button[text()='да все привыкли']");
    // Верхняя кнопка "Заказать"
    private final By upButton = By.xpath(".//div[contains(@class, 'Header_Nav__AGCXC')]/button");
    // Нижняя кнопка "Заказать"
    private final By lowButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Принять куки
    public void clickCookieAcceptButton() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(cookieAcceptButton));
        driver.findElement(cookieAcceptButton).click();
    }

    // Оформление заказа (Верхнее "Заказать")
    public void clickOrderUpButton() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(upButton));
        driver.findElement(upButton).click();
    }

    // Оформление заказа (Нижнее "Заказать")
    public void clickOrderLowButton() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(lowButton));
        WebElement element = driver.findElement(lowButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowButton).click();
    }

    // Раскрыть вопрос
    public void clickAccordionHeading(int index) {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-" + index)));
        WebElement element = driver.findElement(By.id("accordion__heading-" + index));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-" + index)).click();
    }

    // Сравнить ответ с правильным текстом ответа
    public void textIsCorrect(int index, String answerText){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + index)));
        WebElement element = driver.findElement(By.id("accordion__panel-" + index));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        MatcherAssert.assertThat(driver.findElement(By.id("accordion__panel-" + index)).getText(),is(answerText));
    }
}
