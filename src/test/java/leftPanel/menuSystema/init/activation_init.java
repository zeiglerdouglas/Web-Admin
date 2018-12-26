package test.java.leftPanel.menuSystema.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.activation_test;
import test.java.leftPanel.menuSystema.test.calls_test;


public class activation_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
    public void activation() {
        System.out.println("проверка титла");
        activation_test.activation_title();

        System.out.println("проверка авторизации");
        activation_test.activation_a();

        System.out.println("проверка Табов в меню система");
        activation_test.activation();
    }

}
