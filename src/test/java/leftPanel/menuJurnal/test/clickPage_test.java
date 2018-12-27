package test.java.leftPanel.menuJurnal.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuJurnal.stateJurnal.stateJurnal;

public class clickPage_test extends setUP_local {
    public static void clickPage_a() {
        System.out.println("авторизация");
        stateJurnal.autorizations();

    }
    public static void clickPage_title() {
        System.out.println("проверка титла");
        stateJurnal.title();
    }
    public static void clickPage() {
        System.out.println("проверка Левое меню в наличии");
        stateJurnal.clickPage();
    }

}
