package test.java.leftPanel.menuSystema.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.leftPanel.menuSystema.test.oSystemCenterForm_test;


public class oSystemCenterForm_init extends setUP_local {

    @Test(description = "Свдения о системе", groups = "menuSystem")
    @TestRailId(id = "56886",version = "1")
    public void oSystemCenterForm() {
        System.out.println("проверка титла");
        oSystemCenterForm_test.oSystemCenterForm_title();

        System.out.println("проверка авторизации");
        oSystemCenterForm_test.oSystemCenterForm_a();

        System.out.println("проверка О системе центральная форма");
        oSystemCenterForm_test.oSystemCenterForm();
    }

}
