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
                {0, AnswerTexts.ANSWER_ONE_TEXT},
                {1, AnswerTexts.ANSWER_TWO_TEXT},
                {2, AnswerTexts.ANSWER_THREE_TEXT},
                {3, AnswerTexts.ANSWER_FOUR_TEXT},
                {4, AnswerTexts.ANSWER_FIVE_TEXT},
                {5, AnswerTexts.ANSWER_SIX_TEXT},
                {6, AnswerTexts.ANSWER_SEVEN_TEXT},
                {7, AnswerTexts.ANSWER_EIGHT_TEXT},
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