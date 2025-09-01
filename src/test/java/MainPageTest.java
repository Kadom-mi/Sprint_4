import org.junit.runners.Parameterized;
import page.objects.AnswerTexts;
import page.objects.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class MainPageTest extends PageTest {

    private final int accordionNumber;
    private final String answerText;

    public MainPageTest(int accordionNumber, String answerText ) {
        this.accordionNumber = accordionNumber;
        this.answerText = answerText;
    }

    @Parameterized.Parameters(name = "Текст Вопросы о важном. Элемент: {1}")
    public static Object[][] setTestData() {
        return new Object[][]{
                {0, AnswerTexts.ANSWER_COST_OF_THE_ORDER},
                {1, AnswerTexts.ANSWER_MULTIPLE_ORDERS},
                {2, AnswerTexts.ANSWER_RENTAL_TIME},
                {3, AnswerTexts.ANSWER_ORDER_FOR_TODAY},
                {4, AnswerTexts.ANSWER_EXTEND_OR_REFUND_EARLIER},
                {5, AnswerTexts.ANSWER_CHARGING},
                {6, AnswerTexts.ANSWER_ORDER_CANCELLATION},
                {7, AnswerTexts.ANSWER_MKAD},
        };
    }

    @Test
    public void testAccordionIsCorrect() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickCookieAcceptButton();
        mainPage.clickAccordionHeading(accordionNumber);
        mainPage.textIsCorrect(accordionNumber, answerText);
    }
}