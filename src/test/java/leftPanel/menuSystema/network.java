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

public class network extends setUP_local {

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
    public void network() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        globalTabs.is(visible);

        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        collSystemTabs.get(1).hover().shouldBe(text("Сеть"));
        collSystemTabs.get(1).hover().click();

        System.out.println("определение переменных - внутри вкладки Сеть");
        ElementsCollection collNetwork = tabContainer.$(byClassName("is-scrolling-none")).$$(tagName("td"));

        SelenideElement textIpAdress= collNetwork.get(0).shouldBe(text("IP адрес"));
        SelenideElement textStatusH323= collNetwork.get(2).shouldBe(text("Статус H.323"));
        SelenideElement textStatusSIP= collNetwork.get(4).shouldBe(text("Статус SIP"));
        SelenideElement textStatusCall= collNetwork.get(6).shouldBe(text("Статус звонка"));
        SelenideElement texteth0= collNetwork.get(8).shouldBe(text("eth0"));

        textIpAdress.getText();
        textStatusH323.getText();
        textStatusSIP.getText();
        textStatusCall.getText();
        texteth0.getText();

        System.out.println(textIpAdress);
        System.out.println(textStatusH323);
        System.out.println(textStatusSIP);
        System.out.println(textStatusCall);
        System.out.println(texteth0);


        SelenideElement textInfoIpAdress = collNetwork.get(1);
        SelenideElement textInfoStatusH323 = collNetwork.get(3);
        SelenideElement textInfoStatusSIP = collNetwork.get(5);
        SelenideElement textInfoStatusCall = collNetwork.get(7);
        SelenideElement textInfoeth0 = collNetwork.get(9);

        textInfoIpAdress.getText();
        textInfoStatusH323.getText();
        textInfoStatusSIP.getText();
        textInfoStatusCall.getText();
        textInfoeth0.getText();

        System.out.println(textInfoIpAdress);
        System.out.println(textInfoStatusH323);
        System.out.println(textInfoStatusSIP);
        System.out.println(textInfoStatusCall);
        System.out.println(textInfoeth0);

        System.out.println("собираем кнопочки");
        ElementsCollection but1 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Настройка сети"));
        but1.get(0).hover();
        System.out.println(but1);

        System.out.println("собираем кнопочки");
        ElementsCollection but2 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Настройка SIP"));
        but2.get(0).hover();
        System.out.println(but2);

        System.out.println("собираем кнопочки");
        ElementsCollection but3 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Настройка H.323"));
        but3.get(0).hover();
        System.out.println(but3);

        System.out.println("конец теста");
    }


}
