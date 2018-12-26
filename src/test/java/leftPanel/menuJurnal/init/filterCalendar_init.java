package test.java.leftPanel.menuJurnal.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.filterCalendar_test;
import test.java.leftPanel.menuJurnal.test.subMenu_test;


public class filterCalendar_init extends setUP_local {

    @Test(description = "проверка журнал - календарь ")
    public void filterCalendar() {
        System.out.println("проверка титла");
        filterCalendar_test.filterCalendar_title();

        System.out.println("проверка авторизации");
        filterCalendar_test.filterCalendar_a();

        System.out.println("проверка Табов в меню система");
        filterCalendar_test.filterCalendar();
    }

}
