package autorisations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import setUp.setUP_local;

import static com.codeborne.selenide.Selenide.sleep;

public class autorisation extends setUP_local {
    @Test(description = "пробный")
    public void A() {
        System.out.println("слип");
        sleep(10000);
        System.out.println("конец слипа");

    }
}
