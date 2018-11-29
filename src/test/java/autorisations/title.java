package test.java.autorisations;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class title extends setUP_local {

    @Test(description = "проверка титла перед авторизацией")
    public void title() {
        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.37"));
        System.out.println("проверка титла");
    }

}
