package test.java.leftPanel.menuSystema.test;

import main.java.setUp.setUP_local;
import test.java.leftPanel.menuSystema.stateSystema.stateSystema;

public class codecs_test extends setUP_local {
    public static void codecs_a() {
        System.out.println("авторизация");
        stateSystema.autorizations();

    }
    public static void codecs_title() {
        System.out.println("проверка титла");
        stateSystema.title();
    }
    public static void codecsAudio() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.codecsAudio();
    }
    public static void codecsVideo() {
        System.out.println("проверка Левое меню в наличии");
        stateSystema.codecsVideo();
    }
}
