package test.java.autorisations.autorizations_new;

import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local_oneTest;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import static main.java.base.Group.авторизация;

@Component

public class autorisations_init_new extends setUP_local_oneTest {

    @Test(description = "проверка титла перед авторизацией и авторизация", groups = авторизация)
    @TestRailId(id = "56485",version = "1")
    public void title_autorisations() {
        System.out.println("проверка авторизации");
        autorisations_test_new.Autorizationss("test","12345678");
        System.out.println("проверка прошла - успешно");
    }



    @Test(description = "проверка титла", groups = авторизация)
    @TestRailId(id = "56485",version = "1")
    public void a_autorisations() {
        System.out.println("autorisations_test_new.test_new_auth();");
        autorisations_test_new.test_new_auth();
        System.out.println("autorisations_test_new.test_new_auth();");

    }

}
