package main.java.setUp;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Configuration.browser;


public abstract class setUP_local {
    public static WebDriver driver;
    @BeforeClass()
    public void setUp()throws MalformedURLException {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setBrowserName(BrowserType.CHROME);
        caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        if (browser.equalsIgnoreCase("Chrome"))
            caps = DesiredCapabilities.chrome();

        System.out.println("Запуск Chrome браузера");
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();

        System.out.println("открытие адреса");
        driver.navigate().to("https://10.0.200.191/#/login");

        System.out.println("");

    }
    @AfterClass()
    public void tearDown() {
        System.out.println("Закрываем браузер");
                driver.close();
                driver.quit();
        }

    }

