package test.java.upsidePanel.test;

import main.java.setUp.setUP_local_oneTest;
import test.java.upsidePanel.statePanel.statePanel;

public class inExit_test extends setUP_local_oneTest {
    public static void activation_a() {
        System.out.println("авторизация");
        statePanel.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        statePanel.title();
    }
    public static void inExit() {
        System.out.println("переход в Выход из верхнего меню");
        statePanel.inExit();
    }

}
