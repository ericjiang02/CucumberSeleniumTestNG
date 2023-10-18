package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BeforeAfterStepDefinitions {
    private static WebDriver driver;

    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 10;fi
    public final static int PAGE_LOAD_TIMEOUT = 50;

    @Before
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
