package test.java.upsidePanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.upsidePanel.test.fullScreen_test;

import static main.java.base.Group.upsidePanel;


public class fullScreen_init extends setUP_local {

    @Test(description = "полноэкранный режим", groups = upsidePanel)
    @TestRailId(id = "56493",version = "1")
    public void fullScreen() {
        System.out.println("проверка титла");
        fullScreen_test.activation_title();

        System.out.println("проверка авторизации");
        fullScreen_test.activation_a();

        System.out.println("полноэкранный режим");
        fullScreen_test.fullScreen();
    }

}
