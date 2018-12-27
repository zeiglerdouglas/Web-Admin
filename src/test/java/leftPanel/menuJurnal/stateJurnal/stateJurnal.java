package test.java.leftPanel.menuJurnal.stateJurnal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertTrue;

public class stateJurnal extends setUP_local {

    public static void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.43"));
        System.out.println("проверка фин");
    }

    public static void autorizations() {
        System.out.println("определение всех переменых ");
        SelenideElement global = $(By.id("app"));
        System.out.println("определение поля имя пользователя");
        SelenideElement login = global.$(Selectors.byAttribute("name", "username"));
        System.out.println("проверяем что поле не скрыто");
        login.shouldNotBe(Condition.hidden);
        System.out.println("ввод логина");
        login.setValue("user");
        System.out.println("определение поля пароля");
        SelenideElement password = global.$(Selectors.byAttribute("name", "password"));
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
        } else {
            System.out.println(" -- элемент не найден -- ");
            assertTrue(checkOpen.is(Condition.not(visible)), "Элемент не найден");
        }
        System.out.println("конец теста");
    }


    public static void subMenu() {
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

        System.out.println("собираем коллецию подМеню");
        ElementsCollection colljurnalTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        System.out.println(colljurnalTabs.get(0).getText());
        System.out.println(colljurnalTabs.get(1).getText());
        System.out.println(colljurnalTabs.get(2).getText());
        System.out.println(colljurnalTabs.get(3).getText());
        System.out.println(colljurnalTabs.get(4).getText());
        System.out.println(colljurnalTabs.get(5).getText());
        System.out.println(colljurnalTabs.get(6).getText());
        System.out.println(colljurnalTabs.get(7).getText());

        System.out.println("прокликиваем по пунктам подМеню");
        colljurnalTabs.get(1).hover().click();
        colljurnalTabs.get(2).hover().click();
        colljurnalTabs.get(3).hover().click();
        colljurnalTabs.get(4).hover().click();
        colljurnalTabs.get(5).hover().click();
        colljurnalTabs.get(6).hover().click();
        colljurnalTabs.get(7).hover().click();

        colljurnalTabs.get(0).hover().click();

        System.out.println("конец теста");
    }

    public static void filter() {
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

    public static void pageLine() {
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

        System.out.println("собираем коллецию подМеню");
        ElementsCollection colljurnalTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        System.out.println(colljurnalTabs.get(0).getText());
        System.out.println(colljurnalTabs.get(1).getText());
        System.out.println(colljurnalTabs.get(2).getText());
        System.out.println(colljurnalTabs.get(3).getText());
        System.out.println(colljurnalTabs.get(4).getText());
        System.out.println(colljurnalTabs.get(5).getText());
        System.out.println(colljurnalTabs.get(6).getText());
        System.out.println(colljurnalTabs.get(7).getText());

        System.out.println("прокликиваем по пунктам подМеню");
        colljurnalTabs.get(1).hover().click();
        colljurnalTabs.get(2).hover().click();
        colljurnalTabs.get(3).hover().click();
        colljurnalTabs.get(4).hover().click();
        colljurnalTabs.get(5).hover().click();
        colljurnalTabs.get(6).hover().click();
        colljurnalTabs.get(7).hover().click();

        colljurnalTabs.get(0).hover().click();
        //--
        System.out.println("определение переменной переключения страниц - всего сколько выводить строк страницы перейти поле - перейти ");
        SelenideElement podval = globalCentral.$(byClassName("el-pagination"));
        podval.is(visible);
        System.out.println(podval);
        //--
        System.out.println("всего записей");
        SelenideElement total = podval.$(byClassName("el-pagination__total"));
        System.out.println(total);
        total.is(visible);
        total.hover();
        total.getText();
        System.out.println(total);
        System.out.println("переключение страниц");
        SelenideElement sizes = podval.$(byClassName("el-pagination__sizes"));
        sizes.is(visible);
        System.out.println(sizes);
        sizes.hover();
        sizes.click();
        //--
        SelenideElement dropDown = $(byClassName("el-select-dropdown"));
        dropDown.is(visible);
        SelenideElement page = dropDown.$(byClassName("selected"));
        page.is(visible);
        page.hover();
        System.out.println("Собираем в коллецию");
        ElementsCollection collPageDropDown = dropDown.$(byClassName("el-select-dropdown__list")).$$(tagName("li"));
        System.out.println(collPageDropDown);
        collPageDropDown.get(0).hover().find(byText("5 на странице"));
        collPageDropDown.get(1).hover().find(byText("10 на странице"));
        collPageDropDown.get(2).hover().find(byText("15 на странице"));
        collPageDropDown.get(3).hover().find(byText("20 на странице"));
        collPageDropDown.get(4).hover().find(byText("25 на странице"));
        collPageDropDown.get(5).hover().find(byText("30 на странице"));
        collPageDropDown.get(5).hover().find(byText("35 на странице"));


        System.out.println("переход по страницам с помощью стрелок");

        System.out.println("поле перейти");

        System.out.println("конец теста");
    }

    public static void switchPage() {
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

        System.out.println("собираем коллецию подМеню");
        ElementsCollection colljurnalTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        System.out.println(colljurnalTabs.get(0).getText());
        System.out.println(colljurnalTabs.get(1).getText());
        System.out.println(colljurnalTabs.get(2).getText());
        System.out.println(colljurnalTabs.get(3).getText());
        System.out.println(colljurnalTabs.get(4).getText());
        System.out.println(colljurnalTabs.get(5).getText());
        System.out.println(colljurnalTabs.get(6).getText());
        System.out.println(colljurnalTabs.get(7).getText());


        colljurnalTabs.get(0).hover().click();
        //--
        System.out.println("определение переменной переключения страниц - всего сколько выводить строк страницы перейти поле - перейти ");
        SelenideElement podval = globalCentral.$(byClassName("el-pagination"));
        podval.is(visible);
        System.out.println(podval);
        //--
        System.out.println("всего записей");
        SelenideElement total = podval.$(byClassName("el-pagination__total"));
        System.out.println(total);
        total.is(visible);
        total.hover();
        total.getText();
        System.out.println(total);
        System.out.println("переключение страниц");
        SelenideElement sizes = podval.$(byClassName("el-pagination__sizes"));
        sizes.is(visible);
        System.out.println(sizes);
        sizes.hover();
        sizes.click();
        //--
        SelenideElement dropDown = $(byClassName("el-select-dropdown"));
        dropDown.is(visible);
        SelenideElement page = dropDown.$(byClassName("selected"));
        page.is(visible);
        page.hover();
        System.out.println("Собираем в коллецию раскрывашку из страниц");
        ElementsCollection collPageDropDown = dropDown.$(byClassName("el-select-dropdown__list")).$$(tagName("li"));
        System.out.println(collPageDropDown);
        collPageDropDown.get(0).hover().find(byText("5 на странице"));
        collPageDropDown.get(1).hover().find(byText("10 на странице"));
        collPageDropDown.get(2).hover().find(byText("15 на странице"));
        collPageDropDown.get(3).hover().find(byText("20 на странице"));
        collPageDropDown.get(4).hover().find(byText("25 на странице"));
        collPageDropDown.get(5).hover().find(byText("30 на странице"));
        collPageDropDown.get(6).hover().find(byText("35 на странице"));

        //--
        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(0).hover().find(byText("5 на странице")).click();
        System.out.println("определяем форму выводимых строк");
        SelenideElement centerForm = globalCentral.$(byClassName("el-tab-pane"));
        System.out.println("собираем в коллекцию строки");
        ElementsCollection collString = centerForm.$(byClassName("el-table__body-wrapper")).$$(tagName("tr"));
        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println("проверка вывода не больше 5 строк");
        Assert.assertTrue(collString.get(5).is(hidden));
        //--
        System.out.println("открываем раскрывашку");
        sizes.click();

        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(1).hover().find(byText("10 на странице")).click();

        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println(collString.get(5));
        System.out.println(collString.get(6));
        System.out.println(collString.get(7));
        System.out.println(collString.get(8));
        System.out.println(collString.get(9));
        System.out.println("проверка вывода не больше 10 строк");
        Assert.assertTrue(collString.get(10).is(hidden));

        //--
        System.out.println("открываем раскрывашку");
        sizes.click();

        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(2).hover().find(byText("15 на странице")).click();

        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println(collString.get(5));
        System.out.println(collString.get(6));
        System.out.println(collString.get(7));
        System.out.println(collString.get(8));
        System.out.println(collString.get(9));
        System.out.println(collString.get(10));
        System.out.println(collString.get(11));
        System.out.println(collString.get(12));
        System.out.println(collString.get(13));
        System.out.println(collString.get(14));
        System.out.println("проверка вывода не больше 15 строк");
        Assert.assertTrue(collString.get(15).is(hidden));

        //--
        System.out.println("открываем раскрывашку");
        sizes.click();

        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(3).hover().find(byText("20 на странице")).click();

        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println(collString.get(5));
        System.out.println(collString.get(6));
        System.out.println(collString.get(7));
        System.out.println(collString.get(8));
        System.out.println(collString.get(9));
        System.out.println(collString.get(10));
        System.out.println(collString.get(11));
        System.out.println(collString.get(12));
        System.out.println(collString.get(13));
        System.out.println(collString.get(14));
        System.out.println(collString.get(15));
        System.out.println(collString.get(16));
        System.out.println(collString.get(17));
        System.out.println(collString.get(18));
        System.out.println(collString.get(19));
        System.out.println("проверка вывода не больше 20 строк");
        Assert.assertTrue(collString.get(20).is(hidden));

        //--
        System.out.println("открываем раскрывашку");
        sizes.click();

        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(4).hover().find(byText("25 на странице")).click();

        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println(collString.get(5));
        System.out.println(collString.get(6));
        System.out.println(collString.get(7));
        System.out.println(collString.get(8));
        System.out.println(collString.get(9));
        System.out.println(collString.get(10));
        System.out.println(collString.get(11));
        System.out.println(collString.get(12));
        System.out.println(collString.get(13));
        System.out.println(collString.get(14));
        System.out.println(collString.get(15));
        System.out.println(collString.get(16));
        System.out.println(collString.get(17));
        System.out.println(collString.get(18));
        System.out.println(collString.get(19));
        System.out.println(collString.get(20));
        System.out.println(collString.get(21));
        System.out.println(collString.get(22));
        System.out.println(collString.get(23));
        System.out.println(collString.get(24));
        System.out.println("проверка вывода не больше 25 строк");
        Assert.assertTrue(collString.get(25).is(hidden));

        //--
        System.out.println("открываем раскрывашку");
        sizes.click();

        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(5).hover().find(byText("30 на странице")).click();

        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println(collString.get(5));
        System.out.println(collString.get(6));
        System.out.println(collString.get(7));
        System.out.println(collString.get(8));
        System.out.println(collString.get(9));
        System.out.println(collString.get(10));
        System.out.println(collString.get(11));
        System.out.println(collString.get(12));
        System.out.println(collString.get(13));
        System.out.println(collString.get(14));
        System.out.println(collString.get(15));
        System.out.println(collString.get(16));
        System.out.println(collString.get(17));
        System.out.println(collString.get(18));
        System.out.println(collString.get(19));
        System.out.println(collString.get(20));
        System.out.println(collString.get(21));
        System.out.println(collString.get(22));
        System.out.println(collString.get(23));
        System.out.println(collString.get(24));
        System.out.println(collString.get(25));
        System.out.println(collString.get(26));
        System.out.println(collString.get(27));
        System.out.println(collString.get(28));
        System.out.println(collString.get(29));
        System.out.println("проверка вывода не больше 30 строк");
        Assert.assertTrue(collString.get(30).is(hidden));

        //--
        System.out.println("открываем раскрывашку");
        sizes.click();

        System.out.println("выбираем по очереди из списка страниц количество отображаемых строк на страницу");
        System.out.println("выбираем вывод 5 строк на страницу");
        collPageDropDown.get(6).hover().find(byText("35 на странице")).click();

        System.out.println("выводим строки");
        System.out.println(collString.get(0));
        System.out.println(collString.get(1));
        System.out.println(collString.get(2));
        System.out.println(collString.get(3));
        System.out.println(collString.get(4));
        System.out.println(collString.get(5));
        System.out.println(collString.get(6));
        System.out.println(collString.get(7));
        System.out.println(collString.get(8));
        System.out.println(collString.get(9));
        System.out.println(collString.get(10));
        System.out.println(collString.get(11));
        System.out.println(collString.get(12));
        System.out.println(collString.get(13));
        System.out.println(collString.get(14));
        System.out.println(collString.get(15));
        System.out.println(collString.get(16));
        System.out.println(collString.get(17));
        System.out.println(collString.get(18));
        System.out.println(collString.get(19));
        System.out.println(collString.get(20));
        System.out.println(collString.get(21));
        System.out.println(collString.get(22));
        System.out.println(collString.get(23));
        System.out.println(collString.get(24));
        System.out.println(collString.get(25));
        System.out.println(collString.get(26));
        System.out.println(collString.get(27));
        System.out.println(collString.get(28));
        System.out.println(collString.get(29));
        System.out.println(collString.get(30));
        System.out.println(collString.get(31));
        System.out.println(collString.get(32));
        System.out.println(collString.get(33));
        System.out.println(collString.get(34));
        System.out.println("проверка вывода не больше 35 строк");
        Assert.assertTrue(collString.get(35).is(hidden));


        System.out.println("конец теста");

    }

    public static void clickPage() {
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

        System.out.println("собираем коллецию подМеню");
        ElementsCollection colljurnalTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        System.out.println(colljurnalTabs.get(0).getText());
        System.out.println(colljurnalTabs.get(1).getText());
        System.out.println(colljurnalTabs.get(2).getText());
        System.out.println(colljurnalTabs.get(3).getText());
        System.out.println(colljurnalTabs.get(4).getText());
        System.out.println(colljurnalTabs.get(5).getText());
        System.out.println(colljurnalTabs.get(6).getText());
        System.out.println(colljurnalTabs.get(7).getText());


        colljurnalTabs.get(0).hover().click();
        //--
        System.out.println("определение переменной переключения страниц - всего сколько выводить строк страницы перейти поле - перейти ");
        SelenideElement podval = globalCentral.$(byClassName("el-pagination"));
        podval.is(visible);
        System.out.println(podval);
        //--
        System.out.println("определение переменной номеров страниц");
        SelenideElement numberPages = podval.$(byClassName("el-pager"));
        System.out.println("нажатие на номера страниц");
        numberPages.find(byText("1")).hover().click();
        numberPages.find(byText("2")).hover().click();
        numberPages.find(byText("3")).hover().click();
        numberPages.find(byText("4")).hover().click();

        numberPages.lastChild().hover().click();
        numberPages.find(byText("1")).hover().click();
        //--
        System.out.println("собираем в коллекцию количество страниц всего");
        ElementsCollection collPages = podval.$(byClassName("el-pager")).$$(tagName("li"));
        System.out.println(collPages);
        //--
        System.out.println("переключение страниц с помощью стрелок");
        System.out.println("определение параметра стрелок - next / prev");
        SelenideElement btnNext = podval.$(byClassName("btn-next"));
        SelenideElement btnPrev = podval.$(byClassName("btn-prev"));
        System.out.println("нажатие стрелок - next / prev");

        btnNext.hover().click();
        btnNext.hover().click();
        btnNext.hover().click();
        btnNext.hover().click();
        btnNext.hover().click();

        btnPrev.hover().click();
        btnPrev.hover().click();
        btnPrev.hover().click();
        btnPrev.hover().click();
        btnPrev.hover().click();


        System.out.println("конец теста");
    }

    public static void intoBoxPage() {
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

        System.out.println("собираем коллецию подМеню");
        ElementsCollection colljurnalTabs = globalTabs.$(byClassName("el-tabs__nav")).$$(tagName("div"));
        System.out.println(colljurnalTabs.get(0).getText());
        System.out.println(colljurnalTabs.get(1).getText());
        System.out.println(colljurnalTabs.get(2).getText());
        System.out.println(colljurnalTabs.get(3).getText());
        System.out.println(colljurnalTabs.get(4).getText());
        System.out.println(colljurnalTabs.get(5).getText());
        System.out.println(colljurnalTabs.get(6).getText());
        System.out.println(colljurnalTabs.get(7).getText());


        //--
        System.out.println("определение переменной переключения страниц - всего сколько выводить строк страницы перейти поле - перейти ");
        SelenideElement podval = globalCentral.$(byClassName("el-pagination"));
        podval.is(visible);
        System.out.println(podval);
        //--
        System.out.println("определение параметра окна для ввода страницы");
        SelenideElement intoBox = podval.$(byClassName("el-pagination__jump"));
        SelenideElement box = intoBox.$(byAttribute("type","number"));
        System.out.println("стираем значение страницы в Боксе - выставляем 150");
        box.setValue("");
        box.setValue("150").sendKeys(ENTER);
        System.out.println("стираем значение страницы в Боксе - выставляем 1");
        box.setValue("");
        box.setValue("1").sendKeys(ENTER);
        System.out.println("стираем значение страницы в Боксе - выставляем 9999");
        box.setValue("");
        box.setValue("9999").sendKeys(ENTER);



        System.out.println("конец теста");
    }
}
