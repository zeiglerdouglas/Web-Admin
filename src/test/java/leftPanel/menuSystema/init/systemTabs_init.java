package test.java.leftPanel.menuSystema.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.leftPanelMain.test.availabelMenu_test;
import test.java.leftPanel.menuSystema.test.systemTabs_test;


public class systemTabs_init extends setUP_local {

    @Test(description = "проверка титла перед авторизацией и авторизация")
    public void systemTabs() {
        System.out.println("проверка титла");
        systemTabs_test.systemTabs_title();

        System.out.println("проверка авторизации");
        systemTabs_test.systemTabs_a();

        System.out.println("проверка Табов в меню система");
        systemTabs_test.systemTabs();
    }

}
