package test.java.upsidePanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local_oneTest;
import org.testng.annotations.Test;
import test.java.upsidePanel.test.inConsole_test;


public class inConsole_init extends setUP_local_oneTest {

    @Test(description = "вызов консоли из верхнего меню")
    @TestRailId(id = "56875",version = "1")
    public void inConsole() {
        System.out.println("проверка титла");
        inConsole_test.activation_title();

        System.out.println("проверка авторизации");
        inConsole_test.activation_a();

        System.out.println("проверка перехода в консоль из верхней панели ");
        inConsole_test.inConsole();
    }

}
