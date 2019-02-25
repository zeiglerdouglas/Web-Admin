package test.java.centralUpPanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local_oneTest;
import org.testng.annotations.Test;
import test.java.centralUpPanel.test.upSwitchPanel_test;


public class upSwitchPanel_init extends setUP_local_oneTest {

    @Test(description = "переход по вкладкам верхней панели после добавления")
    @TestRailId(id = "56873",version = "1")
    public void upSwitchPanel() {
        System.out.println("проверка титла");
        upSwitchPanel_test.activation_title();

        System.out.println("проверка авторизации");
        upSwitchPanel_test.activation_a();

        System.out.println("переход по вкладкам верхней панели после добавления ");
        upSwitchPanel_test.upSwitchPanel();
    }

}
