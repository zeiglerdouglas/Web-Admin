package test.java.upsidePanel.test;

import main.java.setUp.setUP_local_oneTest;
import test.java.upsidePanel.statePanel.statePanel;

public class inConsole_test extends setUP_local_oneTest {
    public static void activation_a() {
        System.out.println("авторизация");
        statePanel.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        statePanel.title();
    }
    public static void inConsole() {
        System.out.println("вход в консоле из верхней панели");
        statePanel.inConsole();
    }

}
