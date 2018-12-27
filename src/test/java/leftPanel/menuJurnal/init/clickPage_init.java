package test.java.leftPanel.menuJurnal.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.clickPage_test;
import test.java.leftPanel.menuJurnal.test.switchPage_test;


public class clickPage_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
    public void clickPage() {
        System.out.println("проверка титла");
        clickPage_test.clickPage_title();

        System.out.println("проверка авторизации");
        clickPage_test.clickPage_a();

        System.out.println("проверка Табов в меню система");
        clickPage_test.clickPage();
    }

}
