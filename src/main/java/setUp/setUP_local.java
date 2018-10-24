package setUp;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.browser;

public class setUP_local {
    public WebDriver driver;
    @BeforeClass()
    public void setUp(){
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//        caps.setBrowserName(BrowserType.CHROME);
//        caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
//        if (browser.equalsIgnoreCase("Chrome"))
//            caps = DesiredCapabilities.chrome();

        System.out.println("Запуск Chrome браузера");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();

        System.out.println("");
        driver.navigate().to("http://www.rambler.ru");
        System.out.println("");

    }
    @AfterClass(description = "Закрываем драйвер")
    public void tearDown() {
        System.out.println("закрываем драйвер");
                driver.quit();
        }

    }

