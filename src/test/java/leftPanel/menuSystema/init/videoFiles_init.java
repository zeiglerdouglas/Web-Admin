package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.videoFiles_test;


public class videoFiles_init extends setUP_local {

    @Test(description = "Видео файлы", groups = "menuSystem")
    @TestRailId(id = "56838",version = "1")
    public void videoFiles() {
        System.out.println("проверка титла");
        videoFiles_test.videoFiles_title();

        System.out.println("проверка авторизации");
        videoFiles_test.videoFiles_a();

        System.out.println("проверка Табов в меню система");
        videoFiles_test.videoFiles();
    }

}
