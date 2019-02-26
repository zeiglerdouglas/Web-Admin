package test.java.centralUpPanel.test;

import main.java.setUp.setUP_local;
import test.java.centralUpPanel.stateUpPanel.stateUpPanel;

public class upPanelAdd_test extends setUP_local {
    public static void activation_a() {
        System.out.println("авторизация");
        stateUpPanel.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        stateUpPanel.title();
    }
    public static void upPanelAdd() {
        System.out.println("добавление в верхнию панель навигации");
        stateUpPanel.upPanelAdd();
    }

}
