package test.java.leftPanel.menuJurnal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;

public class filterCalendar extends setUP_local {

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
    public void filter() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement wrapper = global.$(byClassName("app-wrapper"));
        SelenideElement panelLeft = wrapper.$(byClassName("sidebar-container"));
        globalTabs.is(visible);

        System.out.println("переход на вкладку журналы");
        ElementsCollection collLeftPanel = panelLeft.$(byClassName("el-menu")).$$(tagName("a"));
        collLeftPanel.get(1).shouldBe(visible.because("журналы"));
        collLeftPanel.get(1).hover().click();

        System.out.println("определяем сам фильтр - вызов");
        SelenideElement filterSmall = globalCentral.$(byClassName("filter-container"));
        SelenideElement filterSmallEditor = filterSmall.$(byClassName("el-date-editor"));
        filterSmallEditor.is(visible);
        filterSmallEditor.shouldBe(visible);
        filterSmallEditor.hover().click();

        System.out.println("определяем переменные фильтра");
        SelenideElement filterBig = $(byClassName("has-time"));
        filterBig.is(visible);

        System.out.println("определяем переменные фильтра - time-header");
        SelenideElement timeHeader = filterBig.$(byClassName("el-date-range-picker__time-header"));
        timeHeader.is(visible);

        System.out.println("определяем переменные фильтра - body-wrapper");
        SelenideElement bodyWrapper = filterBig.$(byClassName("el-picker-panel__body-wrapper"));
        bodyWrapper.is(visible);

            System.out.println("определяем переменные фильтра - sidebar - сегодня / сутки ");
            SelenideElement sidebar = bodyWrapper.$(byClassName("el-picker-panel__sidebar"));
            sidebar.is(visible);

            System.out.println("определяем переменные фильтра - body - календарик");
            SelenideElement bodyCallender = bodyWrapper.$(byClassName("el-picker-panel__body"));
            bodyCallender.is(visible);

                System.out.println("определяем переменные фильтра - body - календарик - isLeft панель");
                SelenideElement isLeft = bodyCallender.$(byClassName("is-left"));
                isLeft.is(visible);

                System.out.println("определяем переменные фильтра - body - календарик - isRight панель");
                SelenideElement isRight = bodyCallender.$(byClassName("is-right"));
                isRight.is(visible);

        System.out.println("определяем переменные фильтра - panel__footer - Очистить - ОК");
        SelenideElement footer = filterBig.$(byClassName("el-picker-panel__footer"));
        footer.is(visible);


        System.out.println("конец теста");
    }


}
