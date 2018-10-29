package test.java.autorisations.formsAutorisations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
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
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.33"));
        System.out.println("проверка фин");
    }
    @Test(description = "проверка титла перед авторизацией")
    public void switchLanguage() {
        System.out.println("определение всех переменых ");
        SelenideElement global = $(By.id("app"));

        System.out.println("определение кнопки смены языка");
        SelenideElement switchLanguage = global.$(byClassName("el-dropdown"));

        System.out.println("нажали на кнопку смены языка");
        switchLanguage.hover().click();

        System.out.println("определили форму выбора языка");
        SelenideElement switchLanguageDropDown = $(byClassName("el-dropdown-menu--medium"));

        System.out.println("определили кнопки выбора языка РУС/Инг");
        SelenideElement languageRUS = switchLanguageDropDown.$(byText("Русский"));
        SelenideElement languageENG = switchLanguageDropDown.$(byText("English"));

        System.out.println("изменили язык на Инг");
        languageENG.hover().click();

        System.out.println("проверка на push-ENG");
        SelenideElement checkPushENG = $(byAttribute("role","alert"));
        checkPushENG.findElements(byText("switch language success"));
        if (checkPushENG.is(visible)) {
            assertTrue(checkPushENG.is(Condition.text("switch language success")));
            System.out.println("элемент видимый");
        }
        else{
            System.out.println(" -- элемент не найден -- ");
            assertTrue(checkPushENG.is(Condition.not(visible)),"Элемент не найден");
        }

        System.out.println("оиждание скрытия push");
        SelenideElement pushHidden = $(byAttribute("role","alert"));
        pushHidden.waitUntil(hidden,10000);

        System.out.println("нажали на кнопку смены языка");
        switchLanguage.hover().click();

        System.out.println("изменили язык на РУС");
        languageRUS.hover().click();

        System.out.println("проверка на push-RUS");
        SelenideElement checkPushRUS = $(byAttribute("role","alert"));
        checkPushRUS.findElements(byText("успешное переключение языка"));
        if (checkPushRUS.is(visible)) {
            assertTrue(checkPushRUS.is(Condition.text("успешное переключение языка")));
            System.out.println("элемент видимый");
        }
        else{
            System.out.println(" -- элемент не найден -- ");
            assertTrue(checkPushRUS.is(Condition.not(visible)),"Элемент не найден");
        }
        System.out.println("конец теста");
    }

}
