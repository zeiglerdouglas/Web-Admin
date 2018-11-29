package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.cluePlace_test;
import test.java.autorisations.test.passAutorisation_test;

public class passAutorisation_init extends setUP_local {

    @Test(description = "подсказки на форме авторизации")
    public void passAutorisation() {
        System.out.println("проверка титла");
        passAutorisation_test.titleVerivactions();

        System.out.println("Авторизация положительная ");
        passAutorisation_test.passAutorisation();
    }

}
