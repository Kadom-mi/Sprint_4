import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.EnvConfig;

public class PageTest {

    protected WebDriver driver;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome"); // по умолчанию chrome
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }
        driver.get(EnvConfig.BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
