package test.java.leftPanel.menuSystema.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class network_test extends setUP_local {
    public static void network_a() {
        System.out.println("авторизация");
        stateSystema.autorizations();

    }
    public static void network_title() {
        System.out.println("проверка титла");
        stateSystema.title();
    }
    public static void network() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.network();
    }

}
