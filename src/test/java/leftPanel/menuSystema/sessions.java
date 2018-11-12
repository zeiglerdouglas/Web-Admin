package test.java.leftPanel.menuSystema;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;

public class sessions extends setUP_local {

    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.36"));
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
    public void sessions() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        globalTabs.is(visible);

        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        collSystemTabs.get(2).hover().shouldBe(text("Сессии"));
        collSystemTabs.get(2).hover().click();

        System.out.println("определение переменных - внутри вкладки Сеть");
        SelenideElement top = tabContainer.$(byClassName("el-tabs__content"));

        top.find(byText("IP адрес")).hover();
        top.find(byText("Имя пользователя")).hover();
        top.find(byText("ID процесса")).hover();

        ElementsCollection rowrow = top.$(byClassName("is-scrolling-none")).$$(tagName("td"));
        ElementsCollection row1 = rowrow.get(0).findAll(tagName("div"));
        ElementsCollection row2 = rowrow.get(1).findAll(tagName("div"));
        ElementsCollection row3 = rowrow.get(2).findAll(tagName("div"));
        ElementsCollection row4 = rowrow.get(3).findAll(tagName("div"));
        ElementsCollection row5 = rowrow.get(4).findAll(tagName("div"));
        ElementsCollection row6 = rowrow.get(5).findAll(tagName("div"));

        row1.get(0).hover();
        row2.get(0).hover();
        row3.get(0).hover();
        row4.get(0).hover();
        row5.get(0).hover();
        row6.get(0).hover();

        System.out.println(row1);
        System.out.println(row2);
        System.out.println(row3);
        System.out.println(row4);
        System.out.println(row5);
        System.out.println(row6);


        System.out.println("конец теста");
    }

}
