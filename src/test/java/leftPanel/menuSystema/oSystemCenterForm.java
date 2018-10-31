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
    public void centerForm() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        tabContainer.shouldBe(visible);

        ElementsCollection collSystemForms = tabContainer.$(byClassName("el-table__body-wrapper")).$$(tagName("div"));

        SelenideElement textCoreSystem = collSystemForms.get(0).shouldBe(text("Ядро системы"));
        SelenideElement textModelProcessor = collSystemForms.get(2).shouldBe(text("Модель процессора"));
        SelenideElement textCoreProcessor = collSystemForms.get(4).shouldBe(text("Ядер процессора"));
        SelenideElement textAllMemory = collSystemForms.get(6).shouldBe(text("Всего памяти"));
        SelenideElement textClearMemory = collSystemForms.get(8).shouldBe(text("Свободно памяти"));
        SelenideElement textMacAdres = collSystemForms.get(10).shouldBe(text("MAC адреса"));
        SelenideElement textVersionsProg = collSystemForms.get(12).shouldBe(text("Версия П/О"));
        SelenideElement textStatusActiv = collSystemForms.get(14).shouldBe(text("Состояние активации"));
        SelenideElement textCapability = collSystemForms.get(16).shouldBe(text("Возможности"));
        SelenideElement textVersionsAPI = collSystemForms.get(18).shouldBe(text("Версия API"));

        textCoreSystem.getText();
        textModelProcessor.getText();
        textCoreProcessor.getText();
        textAllMemory.getText();
        textClearMemory.getText();
        textMacAdres.getText();
        textVersionsProg.getText();
        textStatusActiv.getText();
        textCapability.getText();
        textVersionsAPI.getText();

        System.out.println(textCoreSystem);
        System.out.println(textModelProcessor);
        System.out.println(textCoreProcessor);
        System.out.println(textAllMemory);
        System.out.println(textClearMemory);
        System.out.println(textMacAdres);
        System.out.println(textVersionsProg);
        System.out.println(textStatusActiv);
        System.out.println(textCapability);
        System.out.println(textVersionsAPI);


        SelenideElement textInfoCoreSystem = collSystemForms.get(1).shouldBe(text("4.2.0-23-generic #28astra39 SMP Tue Mar 1 17:41:12 MSK 2016"));
        SelenideElement textInfoModelProcessor = collSystemForms.get(3).shouldBe(text("Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz"));
        SelenideElement textInfoCoreProcessor = collSystemForms.get(5).shouldBe(text("8"));
        SelenideElement textInfoAllMemory = collSystemForms.get(7).shouldBe(text("kB"));
        SelenideElement textInfoClearMemory = collSystemForms.get(9).shouldBe(text("kB"));
        SelenideElement textInfoMacAdres = collSystemForms.get(11).shouldBe(text("e0:d5:5e:2e:05:38"));
        SelenideElement textInfoVersionsProg = collSystemForms.get(13).shouldBe(text("2.6~176"));
        SelenideElement textInfoStatusActiv = collSystemForms.get(15).shouldBe(text("Активирован"));
        SelenideElement textInfoCapability = collSystemForms.get(17).shouldBe(text("4K, MCU"));
        SelenideElement textInfoVersionsAPI = collSystemForms.get(19).shouldBe(text("1.3.14"));

        textInfoCoreSystem.getText();
        textInfoModelProcessor.getText();
        textInfoCoreProcessor.getText();
        textInfoAllMemory.getText();
        textInfoClearMemory.getText();
        textInfoMacAdres.getText();
        textInfoVersionsProg.getText();
        textInfoStatusActiv.getText();
        textInfoCapability.getText();
        textInfoVersionsAPI.getText();

        System.out.println(textInfoCoreSystem);
        System.out.println(textInfoModelProcessor);
        System.out.println(textInfoCoreProcessor);
        System.out.println(textInfoAllMemory);
        System.out.println(textInfoClearMemory);
        System.out.println(textInfoMacAdres);
        System.out.println(textInfoVersionsProg);
        System.out.println(textInfoStatusActiv);
        System.out.println(textInfoCapability);
        System.out.println(textInfoVersionsAPI);

        SelenideElement activashionsButton = globalCentral.$(byAttribute("type","button")).$(new By.ByTagName("span"));
        activashionsButton.shouldBe(visible);
        System.out.println("конец теста");

    }


}
