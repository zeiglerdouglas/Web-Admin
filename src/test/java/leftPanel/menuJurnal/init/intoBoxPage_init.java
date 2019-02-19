package test.java.leftPanel.menuJurnal.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.intoBoxPage_test;


public class intoBoxPage_init extends setUP_local {

    @Test(description = "переключение по страницам", groups = "menuJurnal")
    @TestRailId(id = "56852",version = "1")
    public void intoBoxPage() {
        System.out.println("проверка титла");
        intoBoxPage_test.intoBoxPage_title();

        System.out.println("проверка авторизации");
        intoBoxPage_test.intoBoxPage_a();

        System.out.println("проверка Табов в меню система");
        intoBoxPage_test.intoBoxPage();
    }

}
