package test.java.centralUpPanel.test;

import main.java.setUp.setUP_local_oneTest;
import test.java.centralUpPanel.stateUpPanel.stateUpPanel;

public class upSwitchPanel_test extends setUP_local_oneTest {
    public static void activation_a() {
        System.out.println("авторизация");
        stateUpPanel.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        stateUpPanel.title();
    }
    public static void upSwitchPanel() {
        System.out.println("переход по вкладкам верхней панели после добавления");
        stateUpPanel.upSwitchPanel();
    }

}
