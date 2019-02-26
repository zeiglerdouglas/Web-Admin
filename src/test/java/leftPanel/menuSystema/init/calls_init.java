package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.calls_test;


public class calls_init extends setUP_local {

    @Test(description = "Звонок", groups = "menuSystem")
    @TestRailId(id = "56837",version = "1")
    public void calls() {
        System.out.println("проверка титла");
        calls_test.calls_title();

        System.out.println("проверка авторизации");
        calls_test.calls_a();

        System.out.println("проверка Табов в меню система");
        calls_test.calls();
    }

}
