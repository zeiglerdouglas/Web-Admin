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


public abstract class setUP_local {
    public static WebDriver driver;
    @BeforeClass(groups = "centralUpPanel")
    public void setUp_centralUpPanel()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "upsidePanel")
    public void setUp_upsidePanel()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");
        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "menuSystem")
    public void setUp_menuSystem()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "menuService")
    public void setUp_menuService()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "menuProperites")
    public void setUp_menuProperites()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "menuJurnal")
    public void setUp_menuJurnal()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "menuConsole")
    public void setUp_menuConsole()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "leftPanel")
    public void setUp_leftPanel()throws MalformedURLException {
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @BeforeClass(groups = "авторизация")
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
        driver.navigate().to("https://10.11.4.201/#/login");

        System.out.println("Адрес открылся");
        System.out.println("-------------------");

    }
    @AfterClass(groups = "centralUpPanel")
    public void tearDown_centralUpPanel() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "upsidePanel")
    public void tearDown_upsidePanel() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "menuSystem")
    public void tearDown_menuSystem() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "menuService")
    public void tearDown_menuService() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "menuProperites")
    public void tearDown_menuProperites() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "menuJurnal")
    public void tearDown_menuJurnal() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "menuConsole")
    public void tearDown_menuConsole() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "leftPanel")
    public void tearDown_leftPanel() {
        System.out.println("Закрываем браузер");
        driver.close();
        driver.quit();
    }
    @AfterClass(groups = "авторизация")
    public void tearDown() {
        System.out.println("Закрываем браузер");
                driver.close();
                driver.quit();
        }

    }

