package test.java.leftPanel.menuSystema;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;

public class codecs extends setUP_local {

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
    public void codecs() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        globalTabs.is(visible);

        System.out.println("переключаемся на Кодеки");
        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        collSystemTabs.get(4).hover().shouldBe(text("Кодеки"));
        collSystemTabs.get(4).hover().click();

        System.out.println("определение переменных - внутри вкладки Кодеки");
        SelenideElement top = tabContainer.$(byClassName("el-tabs__content"));
        ElementsCollection row = top.$$(byClassName("is-scrolling-none"));
        row.get(0).shouldBe(visible).getText();
        assertTrue(row.get(0).is(visible));
        System.out.println(row);

        System.out.println("кнопочки настройки аудио / видео кодеков");
        System.out.println("собираем кнопочки");
        ElementsCollection but1 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Настройка аудио кодеков"));
        but1.get(0).hover();
        assertTrue(but1.get(0).is(visible));
        System.out.println(but1);

        System.out.println("собираем кнопочки");
        ElementsCollection but2 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Настройка видео кодеков"));
        but2.get(0).hover();
        assertTrue(but2.get(0).is(visible));
        System.out.println(but2);


        System.out.println("открываем аудио кодеки");
        but1.get(0).hover().click();
        System.out.println("определение формы аудио кодека");
        SelenideElement audioCodecForms = $(byAttribute("aria-label","Аудио кодеки"));
        assertTrue(audioCodecForms.is(visible));
        System.out.println("закрытие формы аудио кодека ");
        SelenideElement clouseX = audioCodecForms.$(byAttribute("aria-label","Close"));
        clouseX.hover().click();
        assertFalse(audioCodecForms.is(disappears));
        System.out.println("открываем аудио кодеки");
        but1.get(0).hover().click();

        System.out.println("!Отключаем все кодеки!");
        SelenideElement activ = audioCodecForms.$(byText("Активные"));
        activ.shouldBe(visible).hover().click();
        SelenideElement checkActivNumbers = audioCodecForms.$(byText("16/16"));
        assertTrue(checkActivNumbers.is(visible));
        checkActivNumbers.shouldBe(visible).hover().getText();
        System.out.println(checkActivNumbers);
        System.out.println("выбраны 16 из 16 кодеков");

        System.out.println("нажимаем на кнопку переноса в Отключенные кодеки");
        SelenideElement buttonRight = audioCodecForms.$(byClassName("el-icon-arrow-right"));
        assertTrue(buttonRight.is(visible));
        buttonRight.hover().click();
        System.out.println("проверяем наличие перенесения кодеков");
        ElementsCollection activOtkluch = audioCodecForms.$$(byClassName("el-transfer-panel"));
        activOtkluch.get(1).getText();
        System.out.println(activOtkluch);
        SelenideElement Otkluch = audioCodecForms.$(byText("Отключенные"));
        Otkluch.shouldBe(visible).hover().click();
//        SelenideElement checkOtkluch = activOtkluch.get(1).$(byText("Отключенные"));
//        checkOtkluch.hover().click();
        SelenideElement checkOtkluchNumbers = activOtkluch.get(1).$(byText("16/16"));
        checkOtkluchNumbers.hover().getText();
        System.out.println(checkOtkluchNumbers);

        System.out.println("нажимаем кнопку применить");
        SelenideElement buttonAccept = audioCodecForms.$(byText("Применить"));
        buttonAccept.shouldBe(visible).hover().click();

        System.out.println("определяем форму применения настроек");
        SelenideElement acceptForms = $(byClassName("el-message-box"));
        acceptForms.shouldBe(visible).hover();
        acceptForms.find(byText("Применить изменения?")).shouldBe(visible);
        acceptForms.find(byClassName("el-message-box__btns")).shouldBe(visible);
        System.out.println("нажать на кнопку Отмена - закрытия формы подтверждения");
        acceptForms.find(byClassName("el-message-box__btns")).shouldBe(visible).find(byText("Отмена")).hover().click();

        System.out.println("нажимаем кнопку применить");
        buttonAccept.shouldBe(visible).hover().click();

        System.out.println("нажать на кнопку Х - закрытия формы подтверждения");
        acceptForms.find(byAttribute("aria-label","Close")).hover().click();


        System.out.println("нажимаем кнопку применить");
        buttonAccept.shouldBe(visible).hover().click();

        System.out.println("нажать на кнопку ОК");
        acceptForms.find(byClassName("el-message-box__btns")).shouldBe(visible).find(byText("OK")).hover().click();

        System.out.println("убедились - окно закрылось");
        assertFalse(acceptForms.is(disappears));

        System.out.println("конец теста");
    }

}
