package test.java.leftPanel.menuSystema.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.calls_test;
import test.java.leftPanel.menuSystema.test.videoFiles_test;


public class videoFiles_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
    public void videoFiles() {
        System.out.println("проверка титла");
        videoFiles_test.videoFiles_title();

        System.out.println("проверка авторизации");
        videoFiles_test.videoFiles_a();

        System.out.println("проверка Табов в меню система");
        videoFiles_test.videoFiles();
    }

}
