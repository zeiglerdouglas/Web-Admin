package test.java.leftPanel.leftPanelMain.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.leftPanelMain.test.availabelMenu_test;


public class availabelMenu_init extends setUP_local {

    @Test(description = "доступное меню", groups = "leftPanel")
    @TestRailId(id = "56490",version = "1")

    public void availableMenu() {
        System.out.println("проверка титла");
        availabelMenu_test.leftPanel_title();

        System.out.println("проверка авторизации");
        availabelMenu_test.leftPanel_a();

        System.out.println("проверка левого меню на наличие нахождения");
        availabelMenu_test.leftPanel_availabelMenu();
    }

}
