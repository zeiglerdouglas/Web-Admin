package test.java.upsidePanel.statePanel;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local_oneTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;


public class statePanel extends setUP_local_oneTest {

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
    public static void fullScreen() {
        System.out.println("начало теста - полноэкранный режим");
        System.out.println("------------");
        System.out.println("определение переменных");
        SelenideElement global = $(By.id("app"));
        SelenideElement appWrapper = global.$(byClassName("app-wrapper"));
        SelenideElement mainContainer = appWrapper.$(byClassName("main-container"));
        SelenideElement menubar = mainContainer.$(Selectors.byAttribute("role","menubar"));
        SelenideElement rightMenu = menubar.$(byClassName("right-menu"));
        SelenideElement buttonScreenFull = rightMenu.$(byClassName("screenfull"));
        System.out.println(buttonScreenFull);
        System.out.println("находим и обрабатываем кнопку FullScreen");
        buttonScreenFull.hover();
        //--
        System.out.println("находим подсказку при наведении на кнопку");
        ElementsCollection elemcoll = $$(byAttribute("role","tooltip"));
        SelenideElement text = elemcoll.find(Condition.text("Полный экран"));
        System.out.println(text);
        //--
        System.out.println("вход в полноэкранный режим");
        buttonScreenFull.hover().click();
        System.out.println(driver.manage().window().getSize());

        System.out.println("выход в полноэкранный режим");
        buttonScreenFull.hover().click();
        System.out.println(driver.manage().window().getSize());
        System.out.println("конец теста");
    }




}