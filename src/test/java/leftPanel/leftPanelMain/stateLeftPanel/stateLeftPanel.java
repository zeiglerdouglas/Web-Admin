package test.java.leftPanel.leftPanelMain.stateLeftPanel;


import com.codeborne.selenide.*;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class stateLeftPanel extends setUP_local{

    public static void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.48"));
        System.out.println("проверка фин");
    }
    public static void autorizations() {
        System.out.println("определение всех переменых ");
        SelenideElement global = $(By.id("app"));
        System.out.println("определение поля имя пользователя");
        SelenideElement login = global.$(Selectors.byAttribute("name","username"));
        System.out.println("проверяем что поле не скрыто");
        login.shouldNotBe(Condition.hidden);
        System.out.println("ввод логина");
        login.setValue("user");
        System.out.println("определение поля пароля");
        SelenideElement password = global.$(Selectors.byAttribute("name","password"));
        System.out.println("проверяем что поле не скрыто");
        password.shouldNotBe(Condition.hidden);
        System.out.println("ввод пароля");
        password.setValue("12345678");
        System.out.println("определение кнопки войти");
        SelenideElement enter = global.$(byText("Войти"));
        System.out.println("проверяем что поле не скрыто");
        enter.shouldNotBe(Condition.hidden);
        System.out.println("нажать кнопку вход");
        enter.hover().click();
        System.out.println("проверка авторизации - открылась нужная страница");
        SelenideElement checkOpen = global.$(byClassName("menu-wrapper")).$(tagName("a"));
        checkOpen.findElements(byClassName("router-link-active"));
        if (checkOpen.is(visible)) {
            System.out.println("элемент видимый");
        }

        else{
            System.out.println(" -- элемент не найден -- ");
            assertTrue(checkOpen.is(Condition.not(visible)),"Элемент не найден");
        }
        System.out.println("конец теста");
    }
    public static void availabelMenu() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement wrapper = global.$(byClassName("app-wrapper"));
        SelenideElement panelLeft = wrapper.$(byClassName("sidebar-container"));
        panelLeft.shouldBe(visible.because("находиться слева"));

        System.out.println("собираем в коллекцию элементы");
        ElementsCollection collLeftPanel = panelLeft.$(byClassName("el-menu")).$$(tagName("a"));
        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(2).shouldBe(visible.because("консоль"));
        collLeftPanel.get(3).shouldBe(visible.because("сервис"));
        collLeftPanel.get(4).shouldBe(visible.because("настройки"));
        collLeftPanel.get(0).shouldBe(visible.because("система"));

        collLeftPanel.get(1).hover().click();
        collLeftPanel.get(1).isEnabled();
        collLeftPanel.get(2).hover().click();
        collLeftPanel.get(2).isEnabled();
        collLeftPanel.get(3).hover().click();
        collLeftPanel.get(3).isEnabled();
        collLeftPanel.get(4).hover().click();
        collLeftPanel.get(4).isEnabled();
        collLeftPanel.get(0).hover().click();
        collLeftPanel.get(0).isEnabled();


        System.out.println("конец теста");
    }
    public static void tabsPanel() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement wrapper = global.$(byClassName("app-wrapper"));
        SelenideElement panelLeft = wrapper.$(byClassName("sidebar-container"));
        panelLeft.shouldBe(visible.because("находиться слева"));

        System.out.println("собираем в коллекцию элементы");
        ElementsCollection collLeftPanel = panelLeft.$(byClassName("el-menu")).$$(tagName("a"));
        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(2).shouldBe(visible.because("консоль"));
        collLeftPanel.get(3).shouldBe(visible.because("сервис"));
        collLeftPanel.get(4).shouldBe(visible.because("настройки"));
        collLeftPanel.get(0).shouldBe(visible.because("система"));

        collLeftPanel.get(1).hover().click();
        collLeftPanel.get(2).hover().click();
        collLeftPanel.get(3).hover().click();
        collLeftPanel.get(4).hover().click();
        collLeftPanel.get(0).hover().click();


        System.out.println("конец теста");
    }
    public static void leftPanelTrunOff() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement wrapper = global.$(byClassName("app-wrapper"));
        SelenideElement panelLeft = wrapper.$(byClassName("sidebar-container"));
        panelLeft.shouldBe(visible.because("находиться слева"));

        System.out.println("собираем в коллекцию элементы");
        ElementsCollection collLeftPanel = panelLeft.$(byClassName("el-menu")).$$(tagName("a"));
        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(2).shouldBe(visible.because("консоль"));
        collLeftPanel.get(3).shouldBe(visible.because("сервис"));
        collLeftPanel.get(4).shouldBe(visible.because("настройки"));
        collLeftPanel.get(0).shouldBe(visible.because("система"));

        System.out.println("закрыли sidebar");
        System.out.println("определяем и кликаем - гамбургер");
        SelenideElement main = wrapper.$(byClassName("navbar"));
        SelenideElement hamburger = main.$(byClassName("hamburger-container"));
        hamburger.shouldBe(visible);
        hamburger.hover().click();

        System.out.println("определение панели - сложилась");
        SelenideElement hideSideBar = panelLeft.$(byClassName("el-menu--collapse"));
        hideSideBar.shouldBe(visible);

        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(2).shouldBe(visible.because("консоль"));
        collLeftPanel.get(3).shouldBe(visible.because("сервис"));
        collLeftPanel.get(4).shouldBe(visible.because("настройки"));
        collLeftPanel.get(0).shouldBe(visible.because("система"));

        collLeftPanel.get(1).hover().shouldBe(visible);
        collLeftPanel.get(2).hover().shouldBe(visible);
        collLeftPanel.get(3).hover().shouldBe(visible);
        collLeftPanel.get(4).hover().shouldBe(visible);
        collLeftPanel.get(0).hover().shouldBe(visible);
        collLeftPanel.get(2).hover().shouldBe(visible);


        System.out.println("конец теста");
    }
    public static void leftPanelTrunOn() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement wrapper = global.$(byClassName("app-wrapper"));
        SelenideElement panelLeft = wrapper.$(byClassName("sidebar-container"));
        panelLeft.shouldBe(visible.because("находиться слева"));

        System.out.println("собираем в коллекцию элементы");
        ElementsCollection collLeftPanel = panelLeft.$(byClassName("el-menu")).$$(tagName("a"));
        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(2).shouldBe(visible.because("консоль"));
        collLeftPanel.get(3).shouldBe(visible.because("сервис"));
        collLeftPanel.get(4).shouldBe(visible.because("настройки"));
        collLeftPanel.get(0).shouldBe(visible.because("система"));

        System.out.println("определяем и кликаем - гамбургер");
        SelenideElement main = wrapper.$(byClassName("navbar"));
        SelenideElement hamburger = main.$(byClassName("hamburger-container"));
        hamburger.shouldBe(visible);

        System.out.println("открыли sidebar");
        hamburger.shouldBe(visible);
        hamburger.hover().click();
        System.out.println("панель видна");
        panelLeft.shouldBe(visible);
        SelenideElement sideBar = panelLeft.$(byClassName("el-menu"));
        sideBar.shouldBe(visible);

        System.out.println("элементы наместе");
        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(2).shouldBe(visible.because("консоль"));
        collLeftPanel.get(3).shouldBe(visible.because("сервис"));
        collLeftPanel.get(4).shouldBe(visible.because("настройки"));
        collLeftPanel.get(0).shouldBe(visible.because("система"));

        System.out.println("элементы выбираються");
        collLeftPanel.get(1).hover().shouldBe(visible);
        collLeftPanel.get(2).hover().shouldBe(visible);
        collLeftPanel.get(3).hover().shouldBe(visible);
        collLeftPanel.get(4).hover().shouldBe(visible);
        collLeftPanel.get(0).hover().shouldBe(visible);
        System.out.println("конец теста");
    }
}
