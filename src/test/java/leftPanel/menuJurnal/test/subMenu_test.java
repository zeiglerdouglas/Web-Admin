package test.java.leftPanel.menuJurnal.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuJurnal.stateJurnal.stateJurnal;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class subMenu_test extends setUP_local {
    public static void subMenu_a() {
        System.out.println("авторизация");
        stateJurnal.autorizations();

    }
    public static void subMenu_title() {
        System.out.println("проверка титла");
        stateJurnal.title();
    }
    public static void subMenu() {
        System.out.println("проверка Левое меню в наличии");
        stateJurnal.subMenu();
    }

}
