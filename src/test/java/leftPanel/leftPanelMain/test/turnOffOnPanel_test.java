package test.java.leftPanel.leftPanelMain.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.leftPanelMain.stateLeftPanel.stateLeftPanel;

public class turnOffOnPanel_test extends setUP_local {
    public static void turnOffOnPanel_a() {
        System.out.println("авторизация");
        stateLeftPanel.autorizations();

    }
    public static void turnOffOnPanel_title() {
        System.out.println("проверка титла");
        stateLeftPanel.title();
    }
    public static void turnOffOnPanel_on() {
        System.out.println("проверка Левое меню в наличии");
        stateLeftPanel.leftPanelTrunOn();
    }
    public static void turnOffOnPanel_off() {
        System.out.println("проверка Левое меню в наличии");
        stateLeftPanel.leftPanelTrunOff();
    }
}
