package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.switchLanguage_test;
import test.java.autorisations.test.verificationUsers_test;

public class switchLanguage_init extends setUP_local {

    @Test(description = "подсказки на форме авторизации")
    public void switchLanguage() {
        System.out.println("проверка титла");
        switchLanguage_test.titleVerivactions();

        System.out.println("Смена языка на английский и обратно");
        switchLanguage_test.switchLanguage();
    }

}
