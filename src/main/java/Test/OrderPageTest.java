package Test;

import org.example.EnvConfig;
import org.example.MainPage;
import org.example.OrderPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderPageTest {

    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderPageTest(String name, String surname, String address, String metroStation, String phoneNumber, String date,
                         String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Петя", "Петров", "г. Москва", "Андроновка", "+79600000000", "01.8.2025", "трое суток", "чёрный жемчуг", ""},
                {"Настя", "Иванова", "Москва, Петроверигский переулок, 4с2", "Китай-город", "89657654321", "10.10.2035", "сутки", "серая безысходность", "Срочно хочу самокат!"},
        };
    }

    @Test
    public void testClickOrderUpButtonFirefoxDriver() {
        driver = new FirefoxDriver();
        driver.get(EnvConfig.BASE_URL);

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickOrderUpButton();
        placingOrder(orderPage);
        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        orderPage.orderHeaderCorrect();
    }

    @Test
    public void startTestClickOrderLowButtonFirefoxDriver() {
        driver = new FirefoxDriver();
        driver.get(EnvConfig.BASE_URL);;

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickOrderLowButton();
        placingOrder(orderPage);
        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        orderPage.orderHeaderCorrect();
    }

    // Тест не проходит. Заказ не получается оформить. Кнопка "Да" на форме подтверждения не нажимается.
    @Test
    public void testClickOrderUpButtonChromeDriver() {
        driver = new ChromeDriver();
        driver.get(EnvConfig.BASE_URL);

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickOrderUpButton();
        placingOrder(orderPage);
        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        orderPage.orderHeaderCorrect();
    }

    // Тест не проходит. Заказ не получается оформить. Кнопка "Да" на форме подтверждения не нажимается.
    @Test
    public void startTestClickOrderLowButtonChromeDriver() {
        driver = new ChromeDriver();
        driver.get(EnvConfig.BASE_URL);;

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickOrderLowButton();
        placingOrder(orderPage);
        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        orderPage.orderHeaderCorrect();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void placingOrder(OrderPage orderPage){
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetroStation(metroStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.setDate(date);
        orderPage.setRentalPeriod(rentalPeriod);
        orderPage.setColor(color);
        orderPage.setComment(comment);
    }
}


