package test.java.leftPanel.menuSystema.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class calls_test extends setUP_local {
    public static void calls_a() {
        System.out.println("авторизация");
        stateSystema.autorizations();

    }
    public static void calls_title() {
        System.out.println("проверка титла");
        stateSystema.title();
    }
    public static void calls() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.calls();
    }

}
