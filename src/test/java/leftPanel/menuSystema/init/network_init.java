package test.java.leftPanel.menuSystema.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.network_test;
import test.java.leftPanel.menuSystema.test.systemTabs_test;


public class network_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
    public void network() {
        System.out.println("проверка титла");
        network_test.network_title();

        System.out.println("проверка авторизации");
        network_test.network_a();

        System.out.println("проверка Табов в меню система");
        network_test.network();
    }

}
