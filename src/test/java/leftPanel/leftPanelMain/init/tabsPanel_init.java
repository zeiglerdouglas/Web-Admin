package test.java.leftPanel.leftPanelMain.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.leftPanelMain.test.availabelMenu_test;
import test.java.leftPanel.leftPanelMain.test.tabsPanel_test;


public class tabsPanel_init extends setUP_local {

    @Test(description = "проверка титла перед авторизацией и авторизация")
    public void tabsPanel() {
        System.out.println("проверка титла");
        tabsPanel_test.tabsPanel_title();

        System.out.println("проверка авторизации");
        tabsPanel_test.tabsPanel_a();

        System.out.println("проверка tabsPanel");
        tabsPanel_test.tabsPanel();
    }

}
