package org.example;

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

    // "Вопросы о важном"
    // Заголовки вопросов
    // Сколько это стоит? И как оплатить?
    private final By accordionHeading1 = By.id("accordion__heading-0");
    // Хочу сразу несколько самокатов! Так можно?
    private final By accordionHeading2 = By.id("accordion__heading-1");
    // Как рассчитывается время аренды?
    private final By accordionHeading3 = By.id("accordion__heading-2");
    // Можно ли заказать самокат прямо на сегодня?
    private final By accordionHeading4 = By.id("accordion__heading-3");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private final By accordionHeading5 = By.id("accordion__heading-4");
    // Вы привозите зарядку вместе с самокатом?
    private final By accordionHeading6 = By.id("accordion__heading-5");
    // Можно ли отменить заказ?
    private final By accordionHeading7 = By.id("accordion__heading-6");
    // Я живу за МКАДом, привезёте?
    private final By accordionHeading8 = By.id("accordion__heading-7");
    // Ответы на вопросы
    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private final By accordionPanel1 = By.id("accordion__panel-0");
    // Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями,
    // можете просто сделать несколько заказов — один за другим.
    private final By accordionPanel2 = By.id("accordion__panel-1");
    // Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня.
    // Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.
    // Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private final By accordionPanel3 = By.id("accordion__panel-2");
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private final By accordionPanel4 = By.id("accordion__panel-3");
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private final By accordionPanel5 = By.id("accordion__panel-4");
    // Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток
    // — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private final By accordionPanel6 = By.id("accordion__panel-5");
    // Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private final By accordionPanel7 = By.id("accordion__panel-6");
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private final By accordionPanel8 = By.id("accordion__panel-7");

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
    public void clickAccordionHeading1() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading1));
        WebElement element = driver.findElement(accordionHeading1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading1).click();
    }
    public void clickAccordionHeading2() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading2));
        WebElement element = driver.findElement(accordionHeading2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading2).click();
    }
    public void clickAccordionHeading3() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading3));
        WebElement element = driver.findElement(accordionHeading3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading3).click();
    }
    public void clickAccordionHeading4() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading4));
        WebElement element = driver.findElement(accordionHeading4);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading4).click();
    }
    public void clickAccordionHeading5() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading5));
        WebElement element = driver.findElement(accordionHeading5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading5).click();
    }
    public void clickAccordionHeading6() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading6));
        WebElement element = driver.findElement(accordionHeading6);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading6).click();
    }
    public void clickAccordionHeading7() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading7));
        WebElement element = driver.findElement(accordionHeading7);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading7).click();
    }
    public void clickAccordionHeading8() {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionHeading8));
        WebElement element = driver.findElement(accordionHeading8);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading8).click();
    }

    // Сравнить ответ с правильным текстом ответа
    public void textIsCorrect1(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel1));
        MatcherAssert.assertThat(driver.findElement(accordionPanel1).getText(),is(AnswerTexts.answer1Text));
    }
    public void textIsCorrect2(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel2));
        MatcherAssert.assertThat(driver.findElement(accordionPanel2).getText(),is(AnswerTexts.answer2Text));
    }
    public void textIsCorrect3(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel3));
        MatcherAssert.assertThat(driver.findElement(accordionPanel3).getText(),is(AnswerTexts.answer3Text));
    }
    public void textIsCorrect4(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel4));
        MatcherAssert.assertThat(driver.findElement(accordionPanel4).getText(),is(AnswerTexts.answer4Text));
    }
    public void textIsCorrect5(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel5));
        MatcherAssert.assertThat(driver.findElement(accordionPanel5).getText(),is(AnswerTexts.answer5Text));
    }
    public void textIsCorrect6(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel6));
        MatcherAssert.assertThat(driver.findElement(accordionPanel6).getText(),is(AnswerTexts.answer6Text));
    }
    public void textIsCorrect7(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel7));
        MatcherAssert.assertThat(driver.findElement(accordionPanel7).getText(),is(AnswerTexts.answer7Text));
    }
    public void textIsCorrect8(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel8));
        MatcherAssert.assertThat(driver.findElement(accordionPanel8).getText(),is(AnswerTexts.answer8Text));
    }
}
