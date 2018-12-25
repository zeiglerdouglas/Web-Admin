package test.java.leftPanel.menuSystema.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.codecs_test;
import test.java.leftPanel.menuSystema.test.videoFiles_test;


public class codecs_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
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
