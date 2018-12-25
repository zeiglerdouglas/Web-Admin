package test.java.leftPanel.menuSystema.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.network_test;
import test.java.leftPanel.menuSystema.test.sessions_test;


public class sessions_init extends setUP_local {

    @Test(description = "проверка вкадки сеть ")
    public void sessions() {
        System.out.println("проверка титла");
        sessions_test.sessions_title();

        System.out.println("проверка авторизации");
        sessions_test.sessions_a();

        System.out.println("проверка Табов в меню система");
        sessions_test.sessions();
    }

}
