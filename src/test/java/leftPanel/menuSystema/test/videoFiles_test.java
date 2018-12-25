package test.java.leftPanel.menuSystema.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class videoFiles_test extends setUP_local {
    public static void videoFiles_a() {
        System.out.println("авторизация");
        stateSystema.autorizations();

    }
    public static void videoFiles_title() {
        System.out.println("проверка титла");
        stateSystema.title();
    }
    public static void videoFiles() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.videoFiles();
    }

}
