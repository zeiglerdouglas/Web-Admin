package test.java.leftPanel.menuJurnal.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuJurnal.test.filterCalendar_test;


public class filterCalendar_init extends setUP_local {

    @Test(description = "поле для фильтрации", groups = "menuJurnal")
    @TestRailId(id = "56842",version = "1")
    public void filterCalendar() {
        System.out.println("проверка титла");
        filterCalendar_test.filterCalendar_title();

        System.out.println("проверка авторизации");
        filterCalendar_test.filterCalendar_a();

        System.out.println("фильтр - календарь");
        filterCalendar_test.filterCalendar();
    }

}
