package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.activation_test;


public class activation_init extends setUP_local {

    @Test(description = "присутствие кнопки активация",groups = "menuSystem")
    @TestRailId(id = "60008",version = "1")
    public void activation() {
        System.out.println("проверка титла");
        activation_test.activation_title();

        System.out.println("проверка авторизации");
        activation_test.activation_a();

        System.out.println("проверка Табов в меню система");
        activation_test.activation();
    }

}
