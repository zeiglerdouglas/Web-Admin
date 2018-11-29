package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.failAutorisation_test;
import test.java.autorisations.test.passAutorisation_test;

public class failAutorisation_init extends setUP_local {

    @Test(description = "подсказки на форме авторизации")
    public void failAutorisation() {
        System.out.println("проверка титла");
        failAutorisation_test.titleVerivactions();

        System.out.println("Авторизация отрицательная");
        failAutorisation_test.failAutorisation();
    }

}
