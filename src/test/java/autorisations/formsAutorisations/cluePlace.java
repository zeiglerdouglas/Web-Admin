package test.java.autorisations.formsAutorisations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class cluePlace extends setUP_local{
    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.33"));
        System.out.println("проверка фин");
    }
    @Test(description = "проверка титла перед авторизацией")
    public void cluePlace() {
        System.out.println("определение всех переменых ");
        SelenideElement global = $(By.id("app"));
        System.out.println("определение поля имя пользователя");
        SelenideElement login = global.$(Selectors.byAttribute("name","username"));
        System.out.println("определение поля пароля");
        SelenideElement password = global.$(Selectors.byAttribute("name","password"));

        System.out.println("проверяем что поле не скрыто");
        login.shouldNotBe(Condition.hidden);
        System.out.println("проверяем что поле не скрыто");
        password.shouldNotBe(Condition.hidden);
        System.out.println("клик в поле логина");
        login.hover().click();
        System.out.println("клик в поле пароль");
        password.hover().click();
        System.out.println("проверка появления подсказки для поля - логин");
        SelenideElement form = $(byClassName("el-form"));

        form.findElements(byText("Пожалуйста введите корректное имя пользователя")).size();
        System.out.println("клик в поле логина");
        login.hover().click();
        System.out.println("проверка появления подсказки для поля - пароль");
        form.findElements(byText("Пароль не может быть меньше восьми символов")).size();

        System.out.println("конец теста");
    }

}
