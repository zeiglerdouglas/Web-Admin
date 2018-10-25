package test.java.autorisations.formsAutorisations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class switchLanguage extends setUP_local{
    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.32"));
        System.out.println("проверка фин");
    }
    @Test(description = "проверка титла перед авторизацией")
    public void switchLanguage() {
        System.out.println("определение всех переменых ");
        SelenideElement global = $(By.id("app"));
        System.out.println("определение кнопки смены языка");
        SelenideElement switchLanguage = global.$(byClassName("el-dropdown"));
        switchLanguage.hover().click();
        System.out.println();
        SelenideElement switchLanguageDropDown = $(byClassName("el-dropdown-menu--medium"));
        System.out.println();
        SelenideElement languageRUS = switchLanguageDropDown.$(byText("Русский"));
        SelenideElement languageENG = switchLanguageDropDown.$(byText("English"));
        languageENG.hover().click();
        switchLanguage.hover().click();
        languageRUS.hover().click();

        //---
//        SelenideElement login = global.$(Selectors.byAttribute("name","username"));
//        System.out.println("проверяем что поле не скрыто");
//        login.shouldNotBe(Condition.hidden);
//        System.out.println("ввод логина");
//        login.setValue("userA");
//        System.out.println("определение поля пароля");
//        SelenideElement password = global.$(Selectors.byAttribute("name","password"));
//        System.out.println("проверяем что поле не скрыто");
//        password.shouldNotBe(Condition.hidden);
//        System.out.println("ввод пароля");
//        password.setValue("1234567890");
//        System.out.println("определение кнопки войти");
//        SelenideElement enter = global.$(byText("Войти"));
//        System.out.println("проверяем что поле не скрыто");
//        enter.shouldNotBe(Condition.hidden);
//        System.out.println("нажать кнопку вход");
//        enter.hover().click();
//        System.out.println("проверка авторизации - появился push с ошибкой ");
//        SelenideElement checkPush = $(byAttribute("role","alert"));
//        checkPush.findElements(byText("Ошибка авторизации"));
//        System.out.println();
//        if (checkPush.is(visible)) {
//            assertTrue(checkPush.is(Condition.text("Ошибка авторизации")));
//            System.out.println("элемент видимый");
//        }
//
//        else{
//            System.out.println(" -- элемент не найден -- ");
//            assertTrue(checkPush.is(Condition.not(visible)),"Элемент не найден");
//        }
//
        System.out.println("конец теста");
    }

}
