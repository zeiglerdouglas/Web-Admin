package test.java.leftPanel.menuJurnal.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.clickPage_test;


public class clickPage_init extends setUP_local {

    @Test(description = "переходы на страницу ", groups = "menuJurnal")
    @TestRailId(id = "56853",version = "1")
    public void clickPage() {
        System.out.println("проверка титла");
        clickPage_test.clickPage_title();

        System.out.println("проверка авторизации");
        clickPage_test.clickPage_a();

        System.out.println("проверка Табов в меню система");
        clickPage_test.clickPage();
    }

}
