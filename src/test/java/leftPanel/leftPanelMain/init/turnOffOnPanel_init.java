package test.java.leftPanel.leftPanelMain.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.leftPanelMain.test.turnOffOnPanel_test;


public class turnOffOnPanel_init extends setUP_local {

    @Test(description = "сворачивание и разворачивание панели", groups = "leftPanel")
    @TestRailId(id = "56492",version = "1")
    public void turnOffOnPanel () {
        System.out.println("проверка титла");
        turnOffOnPanel_test.turnOffOnPanel_title();

        System.out.println("проверка авторизации");
        turnOffOnPanel_test.turnOffOnPanel_a();

        System.out.println("проверка сворачивание");
        turnOffOnPanel_test.turnOffOnPanel_off();

        System.out.println("проверка разворачивание");
        turnOffOnPanel_test.turnOffOnPanel_on();
    }

}
