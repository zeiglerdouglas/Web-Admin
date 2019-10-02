package test.java.autorisations.autorizations_new;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class User {
	public WebDriver driver;

	SelenideElement PageEnter;
	SelenideElement userMenu;

	SelenideElement PageIn;
	SelenideElement appWrapper;
	SelenideElement tabContainer;

	public User() {
		PageEnter = $(byId("app"));
		userMenu = PageEnter.$(byClassName("el-button"));

	}

	
	public SelenideElement LoginAndRegistration() {
		userMenu.waitUntil(text("Войти"),15000);
		userMenu.$(byText("Войти")).hover().click();
		return $(byId("app"));
	}
   public SelenideElement Title()
   {
	   System.out.println("проверка титла");

	   driver.getTitle().contains("Largo Admin 3.7.50");
	   assertTrue(driver.getTitle().contains("Largo Admin 3.7.50"));
	   System.out.println("успешное - проверка титла");
	   return $(byId("app"));
   }
}
