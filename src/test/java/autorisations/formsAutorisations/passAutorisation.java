package test.java.autorisations.formsAutorisations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertTrue;

public class passAutorisation extends setUP_local{
    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.32"));
        System.out.println("проверка фин");
    }
    @Test(description = "проверка титла перед авторизацией")
    public void autorizations() {
        System.out.println("определение всех переменых ");
        SelenideElement global = Selenide.$(By.id("app"));
        System.out.println("ввод логина");
        SelenideElement login = global.$(Selectors.byAttribute("name","username"));
        login.shouldNotBe(Condition.hidden);
        login.setValue("user");
        sleep(7);
        System.out.println("ввод пароля");
        System.out.println("нажать кнопку вход");
        System.out.println("проверка авторизации");

    }
}
