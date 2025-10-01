import page.objects.MainPage;
import page.objects.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderPageTest extends PageTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderPageTest(String name, String surname, String address, String metroStation, String phoneNumber,
                         String date, String rentalPeriod, String color, String comment) {
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

    @Parameterized.Parameters(name = "Оформление заказа. Данные: {0} {1}")
    public static Object[][] setDataForOrder() {
        return new Object[][] {
                {"Петя", "Петров", "г. Москва", "Андроновка", "+79600000000", "01.8.2025",
                        "трое суток", "чёрный жемчуг", ""},
                {"Настя", "Иванова", "Москва, Петроверигский переулок, 4с2", "Китай-город", "89657654321", "10.10.2035",
                        "сутки", "серая безысходность", "Срочно хочу самокат!"},
        };
    }

    @Test
    public void testClickOrderUpButton() {

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickOrderUpButton();
        placingOrder(orderPage);
    }

    @Test
    public void startTestClickOrderLowButton() {

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickOrderLowButton();
        placingOrder(orderPage);
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

        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        orderPage.orderHeaderCorrect();
    }
}


