package test.java.leftPanel.leftPanelMain.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.leftPanelMain.test.tabsPanel_test;


public class tabsPanel_init extends setUP_local {

    @Test(description = "переход между вкладками", groups = "leftPanel")
    @TestRailId(id = "56491",version = "1")
    public void tabsPanel() {
        System.out.println("проверка титла");
        tabsPanel_test.tabsPanel_title();

        System.out.println("проверка авторизации");
        tabsPanel_test.tabsPanel_a();

        System.out.println("проверка tabsPanel");
        tabsPanel_test.tabsPanel();
    }

}
