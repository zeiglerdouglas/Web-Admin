package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.systemTabs_test;


public class systemTabs_init extends setUP_local {

    @Test(description = "переход по вкладкам", groups = "menuSystem")
    @TestRailId(id = "56833",version = "1")
    public void systemTabs() {
        System.out.println("проверка титла");
        systemTabs_test.systemTabs_title();

        System.out.println("проверка авторизации");
        systemTabs_test.systemTabs_a();

        System.out.println("проверка Табов в меню система");
        systemTabs_test.systemTabs();
    }

}
