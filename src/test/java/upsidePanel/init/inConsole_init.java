package test.java.upsidePanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.upsidePanel.test.inConsole_test;

import static main.java.base.Group.upsidePanel;


public class inConsole_init extends setUP_local {

    @Test(description = "переход в консоль из верхнего меню", groups = upsidePanel)
    @TestRailId(id = "56493",version = "1")
    public void inConsole() {
        System.out.println("проверка титла");
        inConsole_test.activation_title();

        System.out.println("проверка авторизации");
        inConsole_test.activation_a();

        System.out.println("переход в консоль из верхнего меню");
        inConsole_test.inConsole();
    }

}
