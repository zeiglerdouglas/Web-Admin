package test.java.centralUpPanel.test;

import main.java.setUp.setUP_local_oneTest;
import test.java.centralUpPanel.stateUpPanel.stateUpPanel;
import test.java.upsidePanel.statePanel.statePanel;

public class upPanelAdd_test extends setUP_local_oneTest {
    public static void activation_a() {
        System.out.println("авторизация");
        stateUpPanel.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        stateUpPanel.title();
    }
    public static void upPanelAdd() {
        System.out.println("переход в Смена языков из верхнего меню");
        stateUpPanel.upPanelAdd();
    }

}
