package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.sessions_test;


public class sessions_init extends setUP_local {

    @Test(description = "Сессии", groups = "menuSystem")
    @TestRailId(id = "56836",version = "1")
    public void sessions() {
        System.out.println("проверка титла");
        sessions_test.sessions_title();

        System.out.println("проверка авторизации");
        sessions_test.sessions_a();

        System.out.println("проверка Табов в меню система");
        sessions_test.sessions();
    }

}
