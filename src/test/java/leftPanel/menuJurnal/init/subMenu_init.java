package test.java.leftPanel.menuJurnal.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.subMenu_test;
import test.java.leftPanel.menuSystema.test.calls_test;


public class subMenu_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
    public void subMenu() {
        System.out.println("проверка титла");
        subMenu_test.subMenu_title();

        System.out.println("проверка авторизации");
        subMenu_test.subMenu_a();

        System.out.println("проверка Табов в меню система");
        subMenu_test.subMenu();
    }

}
