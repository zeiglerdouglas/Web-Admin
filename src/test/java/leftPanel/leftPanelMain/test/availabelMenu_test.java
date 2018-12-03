package test.java.leftPanel.leftPanelMain.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import main.java.setUp.setUP_local;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.java.autorisations.stateAutorisations.state;
import test.java.leftPanel.leftPanelMain.stateLeftPanel.stateLeftPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;
import static org.testng.Assert.assertTrue;
import static test.java.autorisations.stateAutorisations.state.Autorisation;

public class availabelMenu_test extends setUP_local {
    public static void leftPanel_a() {
        System.out.println("авторизация");
        stateLeftPanel.autorizations();

    }
    public static void leftPanel_title() {
        System.out.println("проверка титла");
        stateLeftPanel.title();
    }
    public static void leftPanel_availabelMenu() {
        System.out.println("проверка Левое меню в наличии");
        stateLeftPanel.availabelMenu();
    }

}
