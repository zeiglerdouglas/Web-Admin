package test.java.autorisations.init;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.test.autorisations_test;
import test.java.autorisations.test.cluePlace_test;

import static test.java.autorisations.stateAutorisations.state.title;

public class cluePlace_init extends setUP_local {

    @Test(description = "подсказки на форме авторизации")
    public void cluePlace() {
        System.out.println("проверка титла");
        cluePlace_test.titleVerivactions();

        System.out.println("проверка подсказок");
        cluePlace_test.cluePass();
    }

}
