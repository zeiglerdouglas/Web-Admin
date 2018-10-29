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

public class oSystemCenterForm extends setUP_local {

    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.33"));
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
    public void centerForm() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        tabContainer.shouldBe(visible);

        ElementsCollection collSystemForms = tabContainer.$(byClassName("el-table__body-wrapper")).$$(tagName("tr"));
        collSystemForms.get(0).is(visible);
        collSystemForms.get(1).is(visible);
        collSystemForms.get(2).is(visible);
        collSystemForms.get(3).is(visible);
        collSystemForms.get(4).is(visible);
        collSystemForms.get(5).is(visible);
        collSystemForms.get(6).is(visible);
        collSystemForms.get(7).is(visible);
        collSystemForms.get(8).is(visible);
        collSystemForms.get(9).is(visible);


//        collSystemForms.get(0).find(byText("Ядро системы")).shouldNotBe(visible).hover();
//        collSystemForms.get(1).find(byText("Модель процессора")).shouldBe(visible).hover();
//        collSystemForms.get(2).find(byText("Ядер процессора")).shouldBe(visible).hover();
//        collSystemForms.get(3).find(byText("Всего памяти")).shouldBe(visible).hover();
//        collSystemForms.get(4).find(byText("Свободно памяти")).shouldBe(visible).hover();
//        collSystemForms.get(5).find(byText("MAC адреса")).shouldBe(visible).hover();
//        collSystemForms.get(6).find(byText("Версия П/О")).shouldBe(visible).hover();
//        collSystemForms.get(7).find(byText("Состояние активации")).shouldBe(visible).hover();
//        collSystemForms.get(8).find(byText("Возможности")).shouldBe(visible).hover();
//        collSystemForms.get(9).find(byText("Версия API")).shouldBe(visible).hover();


        System.out.println("конец теста");
    }


}
