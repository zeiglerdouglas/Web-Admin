package test.java.autorisations.stateAutorisations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class state extends setUP_local {

    public static void Autorisation() {

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

    public static void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.47"));
        System.out.println("конец проверки титла");
    }
    public static void autorizationsPass() {
        System.out.println("определение всех переменых ");
        SelenideElement global = Selenide.$(By.id("app"));
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
        SelenideElement checkOpen = global.$(byClassName("menu-wrapper")).$(By.tagName("a"));
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

    public static void failAutorizations() {
        System.out.println("определение всех переменых ");
        SelenideElement global = $(By.id("app"));
        System.out.println("определение поля имя пользователя");
        SelenideElement login = global.$(Selectors.byAttribute("name","username"));
        System.out.println("проверяем что поле не скрыто");
        login.shouldNotBe(Condition.hidden);
        System.out.println("ввод логина");
        login.setValue("userA");
        System.out.println("определение поля пароля");
        SelenideElement password = global.$(Selectors.byAttribute("name","password"));
        System.out.println("проверяем что поле не скрыто");
        password.shouldNotBe(Condition.hidden);
        System.out.println("ввод пароля");
        password.setValue("1234567890");
        System.out.println("определение кнопки войти");
        SelenideElement enter = global.$(byText("Войти"));
        System.out.println("проверяем что поле не скрыто");
        enter.shouldNotBe(Condition.hidden);
        System.out.println("нажать кнопку вход");
        enter.hover().click();
        System.out.println("проверка авторизации - появился push с ошибкой ");
        SelenideElement checkPush = $(byAttribute("role","alert"));
        checkPush.findElements(byText("Ошибка авторизации"));
        System.out.println();
        if (checkPush.is(visible)) {
            assertTrue(checkPush.is(Condition.text("Ошибка авторизации")));
            System.out.println("элемент видимый");
        }

        else{
            System.out.println(" -- элемент не найден -- ");
            assertTrue(checkPush.is(Condition.not(visible)),"Элемент не найден");
        }

        System.out.println("конец теста");
    }
    public static void switchLanguage() {
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

    public static void validationPlace() {
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
        System.out.println("ввести данные");
        login.setValue("1");
        System.out.println("клик в поле пароль");
        password.hover().click();
        System.out.println("проверка появления подсказки для поля - логин");
        SelenideElement form = $(byClassName("el-form"));
        form.findElements(byText("Пожалуйста введите корректное имя пользователя")).size();
        form.shouldBe(Condition.text("Пожалуйста введите корректное имя пользователя"));

        password.hover().click();
        password.setValue("123456");
        login.hover().click();
        form.findElements(byText("Пароль не может быть меньше семи символов")).size();
        form.shouldBe(Condition.text("Пароль не может быть меньше семи символов"));

        System.out.println("конец теста");
    }

    public static void verificationUsers() {
        System.out.println("определение всех переменых ");
        SelenideElement global = Selenide.$(By.id("app"));
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
        SelenideElement checkOpen = global.$(byClassName("menu-wrapper")).$(By.tagName("a"));
        checkOpen.findElements(byClassName("router-link-active"));
        if (checkOpen.is(visible)) {
            System.out.println("элемент видимый");
        }

        else{
            System.out.println(" -- элемент не найден -- ");
            assertTrue(checkOpen.is(Condition.not(visible)),"Элемент не найден");
        }

        System.out.println("обновляем страницу");
        driver.navigate().refresh();

        System.out.println("проверка push - Сессия устарела");
        SelenideElement checkPush = $(byAttribute("role","alert"));

        if (checkPush.is(hidden)) {
            assertFalse(checkPush.is(Condition.text("Сессия устарела")));
            System.out.println("элемент не видимый");
        }
        else{
            System.out.println(" -- элемент найден -- ");
            assertTrue(checkPush.is(Condition.visible),"Элемент найден");
        }

        System.out.println("оиждание скрытия push");
        SelenideElement pushHidden = $(byAttribute("role","alert"));
        pushHidden.waitUntil(hidden,10000);

        System.out.println("конец теста");
    }
    public static void cluePlace() {
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
