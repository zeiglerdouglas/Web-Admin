package main.java.setUp;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.browser;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;


public class setUP_local_oneTest {
    public static WebDriver driver;

    @BeforeClass()
    public void setUp()throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setBrowserName(BrowserType.CHROME);
        caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        if (browser.equalsIgnoreCase("Chrome"))
            caps = DesiredCapabilities.chrome();
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");

        System.out.println("Запуск Chrome браузера");
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        System.out.println("открытие адреса");
        driver.navigate().to("https://10.0.200.168/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }

    @AfterClass()
    public void tearDown() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }

    }

