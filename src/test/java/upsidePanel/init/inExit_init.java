package test.java.upsidePanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local_oneTest;
import org.testng.annotations.Test;
import test.java.upsidePanel.test.inExit_test;


public class inExit_init extends setUP_local_oneTest {

    @Test(description = "переход в Выход из верхнего меню")
    @TestRailId(id = "56495",version = "1")
    public void inExit() {
        System.out.println("проверка титла");
        inExit_test.activation_title();

        System.out.println("проверка авторизации");
        inExit_test.activation_a();

        System.out.println("переход в Выход из верхнего меню");
        inExit_test.inExit();
    }

}
