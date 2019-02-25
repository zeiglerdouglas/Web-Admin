package test.java.centralUpPanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local_oneTest;
import org.testng.annotations.Test;
import test.java.centralUpPanel.test.upPanelAdd_test;


public class upPanelAdd_init extends setUP_local_oneTest {

    @Test(description = "заполнение / наполнение верхней панели ")
    @TestRailId(id = "56872",version = "1")
    public void upPanelAdd() {
        System.out.println("проверка титла");
        upPanelAdd_test.activation_title();

        System.out.println("проверка авторизации");
        upPanelAdd_test.activation_a();

        System.out.println("заполнение / наполнение верхней панели ");
        upPanelAdd_test.upPanelAdd();
    }

}
