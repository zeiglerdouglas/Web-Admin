package test.java.upsidePanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local_oneTest;
import org.testng.annotations.Test;
import test.java.upsidePanel.test.fullScreen_test;


public class fullScreen_init extends setUP_local_oneTest {

    @Test(description = "полноэкранный режим")
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
