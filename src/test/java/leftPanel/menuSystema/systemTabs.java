package test.java.leftPanel.menuSystema;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;

public class systemTabs extends setUP_local {

    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.34"));
        System.out.println("проверка фин");
    }
    @Test(description = "проверка титла перед авторизацией")
    public void autorizations() {
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
    @Test(description = "левая панель сворачиваем")
    public void systemTabs() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        globalTabs.is(visible);

        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));

        collSystemTabs.get(1).hover().shouldBe(visible);
        collSystemTabs.get(2).hover().shouldBe(visible);
        collSystemTabs.get(3).hover().shouldBe(visible);
        collSystemTabs.get(4).hover().shouldBe(visible);
        collSystemTabs.get(5).hover().shouldBe(visible);
        collSystemTabs.get(0).hover().shouldBe(visible);

        collSystemTabs.get(1).hover().click();
        collSystemTabs.get(2).hover().click();
        collSystemTabs.get(3).hover().click();
        collSystemTabs.get(4).hover().click();
        collSystemTabs.get(5).hover().click();
        collSystemTabs.get(0).hover().click();

        System.out.println("конец теста");
    }


}