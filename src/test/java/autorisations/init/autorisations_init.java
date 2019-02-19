package test.java.autorisations.init;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
import test.java.autorisations.test.autorisations_test;

import static main.java.base.Group.авторизация;

@Component

public class autorisations_init extends setUP_local {

    @Test(description = "проверка титла перед авторизацией и авторизация", groups = авторизация)
    @TestRailId(id = "56485",version = "1")

    public void title_autorisations() {
        System.out.println("проверка титла");
        autorisations_test.autorisations_title();

        System.out.println("проверка авторизации");
        autorisations_test.autorisations_a();
    }

}
