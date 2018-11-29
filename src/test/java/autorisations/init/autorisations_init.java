package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.autorisations_test;

import static org.testng.Assert.assertTrue;


public class autorisations_init extends setUP_local {

    @Test(description = "проверка титла перед авторизацией и авторизация")
    public void title_autorisations() {
        System.out.println("проверка титла");
        autorisations_test.autorisations_title();

        System.out.println("проверка авторизации");
        autorisations_test.autorisations_a();
    }

}
