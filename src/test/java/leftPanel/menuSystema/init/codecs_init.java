package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.codecs_test;


public class codecs_init extends setUP_local {

    @Test(description = "кодеки", groups = "menuSystem")
    @TestRailId(id = "56961",version = "1")
    public void codecs() {
        System.out.println("проверка титла");
        codecs_test.codecs_title();

        System.out.println("проверка авторизации");
        codecs_test.codecs_a();

        System.out.println("проверка кодеков Аудио");
        codecs_test.codecsAudio();

        System.out.println("проверка кодеков Видео");
        codecs_test.codecsVideo();
    }

}
