package page.objects;

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

    private final By[] accordionHeading = new By[8];
    private final By[] accordionPanel = new By[8];

    public MainPage(WebDriver driver) {
        this.driver = driver;

        for (int i = 0; i < 8; i++)
        {
            accordionHeading[i] = By.id("accordion__heading-" + i);
            accordionPanel[i] = By.id("accordion__panel-" + i);
        }
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
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading[index]));
        WebElement element = driver.findElement(accordionHeading[index]);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading[index]).click();
    }

    // Сравнить ответ с правильным текстом ответа
    public void textIsCorrect(int index, String answerText){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel[index]));
        WebElement element = driver.findElement(accordionPanel[index]);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        MatcherAssert.assertThat(driver.findElement(accordionPanel[index]).getText(),is(answerText));
    }
}
