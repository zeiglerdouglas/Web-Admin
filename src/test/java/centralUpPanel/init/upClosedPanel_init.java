package test.java.centralUpPanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.centralUpPanel.test.upClosedPanel_test;

import static main.java.base.Group.centralUpPanel;


public class upClosedPanel_init extends setUP_local {

    @Test(description = "закрытие вкладок в верхней панели ",groups = centralUpPanel)
    @TestRailId(id = "56874",version = "1")
    public void upClosedPanel() {
        System.out.println("проверка титла");
        upClosedPanel_test.activation_title();

        System.out.println("проверка авторизации");
        upClosedPanel_test.activation_a();

        System.out.println("закрытие вкладок в верхней панели ");
        upClosedPanel_test.upClosedPanel();
    }

}
