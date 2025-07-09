package Test;

import org.example.EnvConfig;
import org.example.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPageTest {

    private WebDriver driver;

    @Test
    public void testAccordionIsCorrectFirefoxDriver() {
        driver = new FirefoxDriver();
        driver.get(EnvConfig.BASE_URL);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickAccordionHeading1();
        mainPage.textIsCorrect1();

        mainPage.clickAccordionHeading2();
        mainPage.textIsCorrect2();

        mainPage.clickAccordionHeading3();
        mainPage.textIsCorrect3();

        mainPage.clickAccordionHeading4();
        mainPage.textIsCorrect4();

        mainPage.clickAccordionHeading5();
        mainPage.textIsCorrect5();

        mainPage.clickAccordionHeading6();
        mainPage.textIsCorrect6();

        mainPage.clickAccordionHeading7();
        mainPage.textIsCorrect7();

        mainPage.clickAccordionHeading8();
        mainPage.textIsCorrect8();
    }

    @Test
    public void testAccordionIsCorrectChromeDriver() {
        driver = new ChromeDriver();
        driver.get(EnvConfig.BASE_URL);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickAccordionHeading1();
        mainPage.textIsCorrect1();

        mainPage.clickAccordionHeading2();
        mainPage.textIsCorrect2();

        mainPage.clickAccordionHeading3();
        mainPage.textIsCorrect3();

        mainPage.clickAccordionHeading4();
        mainPage.textIsCorrect4();

        mainPage.clickAccordionHeading5();
        mainPage.textIsCorrect5();

        mainPage.clickAccordionHeading6();
        mainPage.textIsCorrect6();

        mainPage.clickAccordionHeading7();
        mainPage.textIsCorrect7();

        mainPage.clickAccordionHeading8();
        mainPage.textIsCorrect8();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}