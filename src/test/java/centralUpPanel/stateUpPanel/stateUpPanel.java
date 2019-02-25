package test.java.centralUpPanel.stateUpPanel;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local_oneTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;


public class stateUpPanel extends setUP_local_oneTest {

    public static void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.49"));
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

    public static void upPanelAdd() {
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

        System.out.println("проверка добавление в панель сверху");
        System.out.println("определение переменных");
        SelenideElement mainContainer = wrapper.$(byClassName("main-container"));
        SelenideElement tagsViewContainer = mainContainer.$(byClassName("tags-view-container"));
        SelenideElement scrollContainer = tagsViewContainer.$(byClassName("scroll-container"));
        SelenideElement scrollWrapper = scrollContainer.$(byClassName("scroll-wrapper"));
        System.out.println(scrollWrapper);
        ElementsCollection collscrollWrapper = scrollWrapper.$$(tagName("a"));
        System.out.println(collscrollWrapper);

        System.out.println("проверка на видимость в панеде элементов");
        collscrollWrapper.get(1).shouldBe(visible.because("Журналы"));
        collscrollWrapper.get(1).hover();
        collscrollWrapper.get(2).shouldBe(visible.because("консоль"));
        collscrollWrapper.get(2).hover();
        collscrollWrapper.get(3).shouldBe(visible.because("сервис"));
        collscrollWrapper.get(3).hover();
        collscrollWrapper.get(4).shouldBe(visible.because("настройки"));
        collscrollWrapper.get(4).hover();
        collscrollWrapper.get(0).shouldBe(visible.because("система"));
        collscrollWrapper.get(0).hover();



        System.out.println("конец теста");
    }
    public static void upSwitchPanel() {
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

        System.out.println("проверка добавление в панель сверху");
        System.out.println("определение переменных");
        SelenideElement mainContainer = wrapper.$(byClassName("main-container"));
        SelenideElement tagsViewContainer = mainContainer.$(byClassName("tags-view-container"));
        SelenideElement scrollContainer = tagsViewContainer.$(byClassName("scroll-container"));
        SelenideElement scrollWrapper = scrollContainer.$(byClassName("scroll-wrapper"));
        System.out.println(scrollWrapper);
        ElementsCollection collscrollWrapper = scrollWrapper.$$(tagName("a"));
        System.out.println(collscrollWrapper);

        System.out.println("проверка на видимость в панеде элементов");
        collscrollWrapper.get(1).shouldBe(visible.because("Журналы"));
        collscrollWrapper.get(1).hover();
        collscrollWrapper.get(2).shouldBe(visible.because("консоль"));
        collscrollWrapper.get(2).hover();
        collscrollWrapper.get(3).shouldBe(visible.because("сервис"));
        collscrollWrapper.get(3).hover();
        collscrollWrapper.get(4).shouldBe(visible.because("настройки"));
        collscrollWrapper.get(4).hover();
        collscrollWrapper.get(0).shouldBe(visible.because("система"));
        collscrollWrapper.get(0).hover();

        System.out.println("переход по вкладкам после добавления");
        collscrollWrapper.get(1).shouldBe(visible.because("Журналы"));
        collscrollWrapper.get(1).click();
        collscrollWrapper.get(1).findAll(byClassName("router-link-exact-active")).texts();
        collscrollWrapper.get(2).shouldBe(visible.because("консоль"));
        collscrollWrapper.get(2).click();
        collscrollWrapper.get(2).findAll(byClassName("router-link-exact-active")).texts();
        collscrollWrapper.get(3).shouldBe(visible.because("сервис"));
        collscrollWrapper.get(3).click();
        collscrollWrapper.get(3).findAll(byClassName("router-link-exact-active")).texts();
        collscrollWrapper.get(4).shouldBe(visible.because("настройки"));
        collscrollWrapper.get(4).click();
        collscrollWrapper.get(4).findAll(byClassName("router-link-exact-active")).texts();
        collscrollWrapper.get(0).shouldBe(visible.because("система"));
        collscrollWrapper.get(0).click();
        collscrollWrapper.get(0).findAll(byClassName("router-link-exact-active")).texts();



        System.out.println("конец теста");


    }
}
