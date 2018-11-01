package test.java.leftPanel.menuSystema;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;

public class videoFiles extends setUP_local {

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
    public void videoFiles() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        globalTabs.is(visible);

        System.out.println("переключаемся на Видео файлы");
        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        collSystemTabs.get(5).hover().shouldBe(text("Видео файлы"));
        collSystemTabs.get(5).hover().click();

        System.out.println("определение переменных - внутри вкладки Видео файлы");
        SelenideElement top = tabContainer.$(byClassName("el-tabs--top"));
        System.out.println(top);
        top.find(byText("Файл"));
        top.is(visible);

        System.out.println("включили галочки глобальной ");
        SelenideElement header = tabContainer.$(byClassName("el-tabs__content")).lastChild();
        SelenideElement headerWrapper = header.$(byClassName("el-table--medium"));
        SelenideElement tableColumn = headerWrapper.$(byClassName("el-table-column--selection"));
        SelenideElement check = tableColumn.$(byClassName("cell"));
        SelenideElement checkBox = check.$(byAttribute("role","checkbox"));
        checkBox.hover().click();


        System.out.println("выключаем включенные галочки ");
        ElementsCollection collNetwork = tabContainer.$(byClassName("is-scrolling-none")).$$(tagName("tr"));
        collNetwork.get(0).find(byClassName("el-table-column--selection")).hover().click();
        collNetwork.get(1).find(byClassName("el-table-column--selection")).hover().click();
        collNetwork.get(2).find(byClassName("el-table-column--selection")).hover().click();
        System.out.println(collNetwork.get(0));
        System.out.println(collNetwork.get(1));
        System.out.println(collNetwork.get(2));


        System.out.println("собираем кнопочки");
        ElementsCollection but1 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Обновить"));
        but1.get(0).hover();
        System.out.println(but1);

        System.out.println("собираем кнопочки");
        ElementsCollection but2 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Удалить"));
        but2.get(0).hover();
        System.out.println(but2);

        System.out.println("собираем кнопочки");
        ElementsCollection but3 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Добавить"));
        but3.get(0).hover();
        System.out.println(but3);

        System.out.println("конец теста");
    }

}
