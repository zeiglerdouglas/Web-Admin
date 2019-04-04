package test.java.leftPanel.menuSystema.stateSystema;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;


public class stateSystema extends setUP_local{

    public static void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.50"));
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
    public static void activation() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        globalCentral.shouldBe(visible);

        SelenideElement activashionsButton = globalCentral.$(byAttribute("type","button")).$(new By.ByTagName("span"));
        activashionsButton.shouldBe(visible);
        activashionsButton.hover().click();

        SelenideElement messageBoxWrapper = $(byClassName("el-message-box__wrapper"));
        SelenideElement messageBox = messageBoxWrapper.$(byClassName("el-message-box"));
        messageBox.shouldBe(visible);

        SelenideElement iconClose = messageBox.$(byClassName("el-icon-close"));
        iconClose.shouldBe(visible);
        iconClose.hover().click();

        System.out.println("конец теста");
    }
    public static void calls() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        globalTabs.is(visible);

        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        collSystemTabs.get(3).hover().shouldBe(text("Звонки"));
        collSystemTabs.get(3).hover().click();

        System.out.println("определение переменных - внутри вкладки Сеть");
        SelenideElement centrFrame = tabContainer.$(byClassName("el-tabs"));
        SelenideElement textCentralFrame = centrFrame.find(byText("Нет активных звонков")).hover();
        System.out.println(textCentralFrame);
        System.out.println("конец теста");
    }
    public static void codecsAudio() {
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

//-- открываем форму аудио кодеков и отключаем --
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
        SelenideElement checkActivNumbers = audioCodecForms.$(byText("9/9"));
        assertTrue(checkActivNumbers.is(visible));
        checkActivNumbers.shouldBe(visible).hover().getText();
        System.out.println(checkActivNumbers);
        System.out.println("выбраны 9 из 9 кодеков");

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
        SelenideElement checkOtkluchNumbers = activOtkluch.get(1).$(byText("9/9"));
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

        System.out.println("проверка push");
        SelenideElement checkPushRUS = $(byAttribute("role","alert"));
        checkPushRUS.findElements(byText("Изменения применены"));
        SelenideElement pushHidden = $(byAttribute("role","alert"));
        pushHidden.waitUntil(hidden,10000);

        System.out.println("проверка в общей таблице сообщения - аудио кадека - аудио кодеков нету");
        row.get(0).find(byText("нет активных кодеков")).shouldBe(visible).hover();

        //-- открываем форму аудио кодеков и Включаем все выключенные --

        System.out.println("открываем аудио кодеки");
        but1.get(0).hover().click();

        System.out.println("!Включаем все кодеки!");
        System.out.println("нажимаем на Отключенные");
        Otkluch.shouldBe(visible).hover().click();
//        SelenideElement checkOtkluch = activOtkluch.get(1).$(byText("Отключенные"));
//        checkOtkluch.hover().click();

        System.out.println("проверяем количество выбранных кодеков");
        activOtkluch.get(1).$(byText("16/16"));
        checkOtkluchNumbers.hover().getText();
        System.out.println(checkOtkluchNumbers);

        System.out.println("нажимаем на кнопку переноса в Отключенные кодеки");
        SelenideElement buttonLeft = audioCodecForms.$(byClassName("el-icon-arrow-left"));
        assertTrue(buttonLeft.is(visible));
        buttonLeft.hover().click();

        System.out.println("выбираем и проверяем 9 аудио кодеков после переноса ");
        activ.shouldBe(visible).hover().click();
        SelenideElement checkActivNumbers16 = audioCodecForms.$(byText("9/9"));
        assertTrue(checkActivNumbers16.is(visible));
        checkActivNumbers16.shouldBe(visible).hover().getText();
        System.out.println(checkActivNumbers16);
        System.out.println("выбраны 9 из 9 кодеков");

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

        System.out.println("проверка push");
        SelenideElement checkPushAccept = $(byAttribute("role","alert"));
        checkPushAccept.findElements(byText("Изменения применены"));
        SelenideElement pushHiddenAccept = $(byAttribute("role","alert"));
        pushHiddenAccept.waitUntil(hidden,10000);

        System.out.println("проверка в общей таблице сообщения - аудио кадека - аудио кодеки есть");

        String rowCodecs = "G7221, OPUS, Speex, G722, PCMA, PCMU, G726, G728, G729, gsm, ms-gsm, iLBC, isac, lpc10, AMR, AMR-WB";
        String rowText = row.get(0).find(byText("G7221, OPUS, Speex, G722, PCMA, PCMU, G726, G728, G729, gsm, ms-gsm, iLBC, isac, lpc10, AMR, AMR-WB")).shouldBe(visible).text();
        boolean eq = rowText.equals(rowCodecs);
        System.out.println(eq);
        assertTrue(eq);

        System.out.println("конец теста");
    }
    public static void codecsVideo() {
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

        System.out.println("собираем кнопочки");
        ElementsCollection but2 = global.$(byClassName("el-tabs__content")).$$(byAttribute("type","button")).filterBy(text("Настройка видео кодеков"));
        but2.get(0).hover();
        assertTrue(but2.get(0).is(visible));
        System.out.println(but2);

//-- открываем форму видео кодеков и отключаем --
        System.out.println("открываем видео кодеки");
        but2.get(0).hover().click();
        System.out.println("определение формы видео кодека");
        SelenideElement audioCodecForms = $(byAttribute("aria-label","Видео кодеки"));
        assertTrue(audioCodecForms.is(visible));
        System.out.println("закрытие формы аудио кодека ");
        SelenideElement clouseX = audioCodecForms.$(byAttribute("aria-label","Close"));
        clouseX.hover().click();
        assertFalse(audioCodecForms.is(disappears));

        System.out.println("открываем видео кодеки");
        but2.get(0).hover().click();

//
        System.out.println("!Отключаем все кодеки!");
        SelenideElement activ = audioCodecForms.$(byText("Активные"));
        activ.shouldBe(visible).hover().click();
        SelenideElement checkActivNumbers = audioCodecForms.$(byText("10/10"));
        assertTrue(checkActivNumbers.is(visible));
        checkActivNumbers.shouldBe(visible).hover().getText();
        System.out.println(checkActivNumbers);
        System.out.println("выбраны 10 из 10 кодеков");

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
        SelenideElement checkOtkluchNumbers = activOtkluch.get(1).$(byText("10/10"));
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

        System.out.println("проверка push");
        SelenideElement checkPushRUS = $(byAttribute("role","alert"));
        checkPushRUS.findElements(byText("Изменения применены"));
        SelenideElement pushHidden = $(byAttribute("role","alert"));
        pushHidden.waitUntil(hidden,10000);

        System.out.println("проверка в общей таблице сообщения - аудио кадека - аудио кодеков нету");
        row.get(0).find(byText("нет активных кодеков")).shouldBe(visible).hover();

        //-- открываем форму видео кодеков и Включаем все выключенные --

        System.out.println("открываем видео кодеки");
        but2.get(0).hover().click();

        System.out.println("!Включаем все кодеки!");
        System.out.println("нажимаем на Отключенные");
        Otkluch.shouldBe(visible).hover().click();
//        SelenideElement checkOtkluch = activOtkluch.get(1).$(byText("Отключенные"));
//        checkOtkluch.hover().click();

        System.out.println("проверяем количество выбранных кодеков");
        activOtkluch.get(1).$(byText("10/10"));
        checkOtkluchNumbers.hover().getText();
        System.out.println(checkOtkluchNumbers);

        System.out.println("нажимаем на кнопку переноса в Отключенные кодеки");
        SelenideElement buttonLeft = audioCodecForms.$(byClassName("el-icon-arrow-left"));
        assertTrue(buttonLeft.is(visible));
        buttonLeft.hover().click();

        System.out.println("выбираем и проверяем 10 аудио кодеков после переноса ");
        activ.shouldBe(visible).hover().click();
        SelenideElement checkActivNumbers10 = audioCodecForms.$(byText("10/10"));
        assertTrue(checkActivNumbers10.is(visible));
        checkActivNumbers10.shouldBe(visible).hover().getText();
        System.out.println(checkActivNumbers10);
        System.out.println("выбраны 10 из 10 кодеков");

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

        System.out.println("проверка push");
        SelenideElement checkPushAccept = $(byAttribute("role","alert"));
        checkPushAccept.findElements(byText("Изменения применены"));
        SelenideElement pushHiddenAccept = $(byAttribute("role","alert"));
        pushHiddenAccept.waitUntil(hidden,10000);
//
        String rowCodecs = "H264, VP8, H265, H263-1998, H263, H261, MP4V-ES, theora, raw, X-MX-VP8";
        String rowText = row.get(0).find(byText("H264, VP8, H265, H263-1998, H263, H261, MP4V-ES, theora, raw, X-MX-VP8")).shouldBe(visible).text();
        boolean eq = rowText.equals(rowCodecs);
        System.out.println(eq);
        assertTrue(eq);
//
        System.out.println("конец теста");
    }
    public static void network() {
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

        SelenideElement textIpAdress= collNetwork.get(0).shouldBe(text("IP адрес")).hover();
        SelenideElement textStatusH323= collNetwork.get(2).shouldBe(text("Статус H.323")).hover();
        SelenideElement textStatusSIP= collNetwork.get(4).shouldBe(text("Статус SIP")).hover();
        SelenideElement textStatusCall= collNetwork.get(6).shouldBe(text("Статус звонка")).hover();
        SelenideElement texteth0= collNetwork.get(8).shouldBe(text("eth0")).hover();

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


        SelenideElement textInfoIpAdress = collNetwork.get(1).hover();
        SelenideElement textInfoStatusH323 = collNetwork.get(3).hover();
        SelenideElement textInfoStatusSIP = collNetwork.get(5).hover();
        SelenideElement textInfoStatusCall = collNetwork.get(7).hover();
        SelenideElement textInfoeth0 = collNetwork.get(9).hover();

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
    public static void centerForm() {
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
        SelenideElement textInfoVersionsProg = collSystemForms.get(13).shouldBe(text("2.6~246"));
        SelenideElement textInfoStatusActiv = collSystemForms.get(15).shouldBe(text("Активирован"));
        SelenideElement textInfoCapability = collSystemForms.get(17).shouldBe(text("4K, MCU"));
        SelenideElement textInfoVersionsAPI = collSystemForms.get(19).shouldBe(text("1.3.23"));

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
    public static void sessions() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        SelenideElement tabContainer = global.$(byClassName("tab-container"));
        globalTabs.is(visible);

        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        collSystemTabs.get(2).hover().shouldBe(text("Сессии"));
        collSystemTabs.get(2).hover().click();

        System.out.println("определение переменных - внутри вкладки Сеть");
        SelenideElement top = tabContainer.$(byClassName("el-tabs__content"));

        top.find(byText("IP адрес")).hover();
        top.find(byText("Имя пользователя")).hover();
        top.find(byText("ID процесса")).hover();

        ElementsCollection rowrow = top.$(byClassName("is-scrolling-none")).$$(tagName("td"));
        ElementsCollection row1 = rowrow.get(0).findAll(tagName("div"));
        ElementsCollection row2 = rowrow.get(1).findAll(tagName("div"));
        ElementsCollection row3 = rowrow.get(2).findAll(tagName("div"));
        ElementsCollection row4 = rowrow.get(3).findAll(tagName("div"));
        ElementsCollection row5 = rowrow.get(4).findAll(tagName("div"));
        ElementsCollection row6 = rowrow.get(5).findAll(tagName("div"));

        row1.get(0).hover();
        row2.get(0).hover();
        row3.get(0).hover();
        row4.get(0).hover();
        row5.get(0).hover();
        row6.get(0).hover();

        System.out.println(row1);
        System.out.println(row2);
        System.out.println(row3);
        System.out.println(row4);
        System.out.println(row5);
        System.out.println(row6);


        System.out.println("конец теста");
    }

    public static void systemTabs() {
        System.out.println("определение переменных");
        SelenideElement global = $(byId("app"));
        SelenideElement globalCentral = global.$(byClassName("main-container"));
        SelenideElement globalTabs = globalCentral.$(byClassName("is-top"));
        globalTabs.is(visible);

        ElementsCollection collSystemTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));

        collSystemTabs.get(1).hover().shouldBe(visible);
        collSystemTabs.get(2).hover().shouldBe(visible);
        collSystemTabs.get(3).hover().shouldBe(visible);
        collSystemTabs.get(4).hover().shouldBe(visible);
        collSystemTabs.get(5).hover().shouldBe(visible);
        collSystemTabs.get(0).hover().shouldBe(visible);

        collSystemTabs.get(1).hover().click();
        collSystemTabs.get(2).hover().click();
        collSystemTabs.get(3).hover().click();
        collSystemTabs.get(4).hover().click();
        collSystemTabs.get(5).hover().click();
        collSystemTabs.get(0).hover().click();

        System.out.println("конец теста");
    }

    public static void videoFiles() {
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
