package test.java.upsidePanel.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.upsidePanel.test.inSwitchLanguage_test;

import static main.java.base.Group.upsidePanel;


public class inSwitchLanguage_init extends setUP_local {

    @Test(description = "переход в Смена языков из верхнего меню", groups = upsidePanel)
    @TestRailId(id = "56494",version = "1")
    public void inSwitchLanguage() {
        System.out.println("проверка титла");
        inSwitchLanguage_test.activation_title();

        System.out.println("проверка авторизации");
        inSwitchLanguage_test.activation_a();

        System.out.println("переход в Смена языков из верхнего меню");
        inSwitchLanguage_test.inSwitchLanguage();
    }

}
