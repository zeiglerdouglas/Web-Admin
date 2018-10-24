package setUp;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class setUP_local {
    public WebDriver driver;
    @BeforeSuite()
    public void setUp(){
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//        caps.setBrowserName(BrowserType.CHROME);
//        caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
//        if (browser.equalsIgnoreCase("Chrome"))
//            caps = DesiredCapabilities.chrome();

        System.out.println("Запуск Chrome браузера");
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();

        System.out.println("");
        driver.navigate().to("https://10.0.200.191/#/login");
        System.out.println("");

    }
    @AfterSuite()
    public void tearDown() {
        System.out.println("Закрываем браузер");
                driver.quit();
        }

    }

