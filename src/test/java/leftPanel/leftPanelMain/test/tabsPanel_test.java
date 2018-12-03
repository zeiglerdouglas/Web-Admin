package test.java.leftPanel.leftPanelMain.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.leftPanelMain.stateLeftPanel.stateLeftPanel;

public class tabsPanel_test extends setUP_local {
    public static void tabsPanel_a() {
        System.out.println("авторизация");
        stateLeftPanel.autorizations();

    }
    public static void tabsPanel_title() {
        System.out.println("проверка титла");
        stateLeftPanel.title();
    }
    public static void tabsPanel() {
        System.out.println("проверка Левое меню в наличии");
        stateLeftPanel.tabsPanel();
    }

}
