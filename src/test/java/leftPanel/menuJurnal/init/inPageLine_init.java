package test.java.leftPanel.menuJurnal.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.filterCalendar_test;
import test.java.leftPanel.menuJurnal.test.inPageLine_test;


public class inPageLine_init extends setUP_local {

    @Test(description = "проверка журнал - календарь ")
    public void inPageLine() {
        System.out.println("проверка титла");
        inPageLine_test.inPageLine_title();

        System.out.println("проверка авторизации");
        inPageLine_test.inPageLine_a();

        System.out.println("проверка Табов в меню система");
        inPageLine_test.inPageLine();
    }

}
