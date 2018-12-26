package test.java.leftPanel.menuSystema.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class activation_test extends setUP_local {
    public static void activation_a() {
        System.out.println("авторизация");
        stateSystema.autorizations();

    }
    public static void activation_title() {
        System.out.println("проверка титла");
        stateSystema.title();
    }
    public static void activation() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.activation();
    }

}
