package test.java.leftPanel.menuJurnal.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.switchPage_test;


public class switchPage_init extends setUP_local {

    @Test(description = "переход по вкладкам", groups = "menuJurnal")
    @TestRailId(id = "56841",version = "1")
    public void switchPage() {
        System.out.println("проверка титла");
        switchPage_test.switchPage_title();

        System.out.println("проверка авторизации");
        switchPage_test.switchPage_a();

        System.out.println("проверка Табов в меню система");
        switchPage_test.switchPage();
    }

}
