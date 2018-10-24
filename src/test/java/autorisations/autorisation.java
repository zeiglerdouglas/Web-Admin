package test.java.autorisations;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class autorisation extends setUP_local {

    @Test(description = "пробный")
    public void A() {


        System.out.println("проверка титла");
        assertTrue(driver.getTitle().contains("Largo Admin 3.7.32"));
        System.out.println("проверка фин");
    }
}
