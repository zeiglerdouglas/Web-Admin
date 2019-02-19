package test.java.leftPanel.menuJurnal.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.inPageLine_test;


public class inPageLine_init extends setUP_local {

    @Test(description = "отображение количества строк на страницу", groups = "menuJurnal")
    @TestRailId(id = "56851",version = "1")
    public void inPageLine() {
        System.out.println("проверка титла");
        inPageLine_test.inPageLine_title();

        System.out.println("проверка авторизации");
        inPageLine_test.inPageLine_a();

        System.out.println("проверка Табов в меню система");
        inPageLine_test.inPageLine();
    }

}
