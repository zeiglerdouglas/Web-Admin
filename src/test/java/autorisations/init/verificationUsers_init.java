package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.validationPlace_test;
import test.java.autorisations.test.verificationUsers_test;

public class verificationUsers_init extends setUP_local {

    @Test(description = "подсказки на форме авторизации")
    public void verificationUsers() {
        System.out.println("проверка титла");
        verificationUsers_test.titleVerivactions();

        System.out.println("Верификация пользователя ");
        verificationUsers_test.verificationUsers();
    }

}
