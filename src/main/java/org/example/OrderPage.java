package org.example;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;

public class OrderPage {

    private final WebDriver driver;

    // Текст об успешном оформлении заказа
    private final By orderHeader = By.xpath(".//div[text()='Заказ оформлен']");
    // Для кого самокат
    // Поле Имя
    private final By nameFieldInput = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private final By surnameFieldInput = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле Адрес: куда привезти заказ
    private final By addressFieldInput = By.xpath
            (".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция метро
    private final By metroStationFieldInput = By.xpath
            (".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Станция метро')]");
    // Обёртка для списка станций метро
    private final By metroList = By.className("select-search__select");
    // Список станций метро
    private final By metroListElement = By.xpath
            (".//div[@class='select-search__select']//div[starts-with(@class,'Order_Text')]");
    // Поле Телефон: на него позвонит курьер
    private final By phoneNumberFieldInput = By.xpath
            (".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    // Поле Когда привезти самокат
    private final By dateFieldInput = By.xpath
            (".//div[starts-with(@class, 'react-datepicker__input-container')]//input");
    // Выбранная дата
    private final By dateSelected = By.className("react-datepicker__day--selected");
    // Обёртка списка Срок аренды
    private final By rentalPeriodFieldInput = By.className("Dropdown-root");
    // Список сроков аренды
    private final By rentalPeriodDropdownOption = By.className("Dropdown-option");
    // Список цветов самоката
    private final By colorFieldInput = By.xpath
            (".//div[starts-with(@class, 'Order_Checkboxes')]//label");
    // Поле Комментарий для курьера
    private final By commentFieldInput = By.xpath
            (".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath
            ("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    // Кнопка подтверждения заказа
    private final By confirmButton = By.xpath(".//button[text()='Да']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заполнение поля Имя
    public void setName(String name){
        driver.findElement(nameFieldInput).sendKeys(name);
    }
    // Заполнение поля Фамилия
    public void setSurname(String surname){
        driver.findElement(surnameFieldInput).sendKeys(surname);
    }
    // Заполнение поля Адрес: куда привезти заказ
    public void setAddress(String address){
        driver.findElement(addressFieldInput).sendKeys(address);
    }
    // Заполнение поля Станция метро
    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationFieldInput).sendKeys(metroStation);
        waitForElementLoad(metroList);
        chooseElementFromDropdownList(metroListElement, metroStation);
    }
    // Заполнение поля Телефон: на него позвонит курьер
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberFieldInput).sendKeys(phoneNumber);
    }
    // Нажатие на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // Заполнение поля Когда привезти самокат
    public void setDate(String date) {
        driver.findElement(dateFieldInput).sendKeys(date);
        waitForElementLoad(dateSelected);
        driver.findElement(dateSelected).click();
    }
    // Заполнение поля Срок аренды
    public void setRentalPeriod(String rentalPeriod){
        driver.findElement(rentalPeriodFieldInput).click();
        chooseElementFromDropdownList(rentalPeriodDropdownOption, rentalPeriod);

    }
    // Заполнение поля Цвет самоката
    public void setColor(String color) {
        chooseElementFromDropdownList(colorFieldInput, color);
    }
    // Заполнение поля Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(commentFieldInput).sendKeys(comment);
    }
    // Нажатия на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    // Подтверждение заказа
    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    // Проверка об успешном оформлении заказа
    public void orderHeaderCorrect(){
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        String orderHeaderText = "Заказ оформлен";
        MatcherAssert.assertThat(driver.findElement(orderHeader).getText(),containsString(orderHeaderText));
    }

    // Ожидание загрузки элемента страницы
    public void waitForElementLoad(By elementToLoad) {
        new WebDriverWait(driver, EnvConfig.EXPLICITY_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementToLoad)));
    }
    // Выбор элемента из выпадающего списка
    public void chooseElementFromDropdownList(By dropdownElements, String elementToChoose) {
        List<WebElement> elementsFiltered = driver.findElements(dropdownElements);
        for (WebElement element : elementsFiltered) {
            if (element.getText().equals(elementToChoose)) {
                element.click();
                break;
            }
        }
    }
}
