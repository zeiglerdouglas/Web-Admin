package test.java.centralUpPanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.centralUpPanel.test.upSwitchPanel_test;

import static main.java.base.Group.centralUpPanel;


public class upSwitchPanel_init extends setUP_local {

    @Test(description = "переход по вкладкам верхней панели после добавления",groups = centralUpPanel)
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
