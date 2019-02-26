package test.java.upsidePanel.test;

import main.java.setUp.setUP_local;
import test.java.upsidePanel.statePanel.statePanel;

public class inSwitchLanguage_test extends setUP_local {
    public static void activation_a() {
        System.out.println("авторизация");
        statePanel.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        statePanel.title();
    }
    public static void inSwitchLanguage() {
        System.out.println("переход в Смена языков из верхнего меню");
        statePanel.inSwitchLanguage();
    }

}
