package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.failAutorisation_test;
import test.java.autorisations.test.validationPlace_test;

public class validationPlace_init extends setUP_local {

    @Test(description = "подсказки на форме авторизации")
    public void validationsPlace() {
        System.out.println("проверка титла");
        validationPlace_test.titleVerivactions();

        System.out.println("Валидация пользователя ");
        validationPlace_test.validation();
    }

}
