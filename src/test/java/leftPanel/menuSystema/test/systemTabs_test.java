package test.java.leftPanel.menuSystema.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.leftPanelMain.stateLeftPanel.stateLeftPanel;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class systemTabs_test extends setUP_local {
    public static void systemTabs_a() {
        System.out.println("авторизация");
        stateSystema.autorizations();

    }
    public static void systemTabs_title() {
        System.out.println("проверка титла");
        stateSystema.title();
    }
    public static void systemTabs() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.systemTabs();
    }

}
