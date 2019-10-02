package test.java.autorisations.autorizations_new;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static main.java.base.Group.LoginUserAdmin;


public class LoginRegistration {
	private String user = null;
	private String password = null;
	SelenideElement PageEnter;
	SelenideElement userField;
	SelenideElement passwordField;
	//--old--
	SelenideElement WhiteBoard;
	SelenideElement LoginWindow;
	SelenideElement RegistrationWindow;
	public WebDriver driver;

	public LoginRegistration() {
//		WhiteBoard = $(byId("whiteboard"));
		PageEnter = $(byId("app"));
		userField = $(Selectors.byAttribute("name","username"));
		passwordField = $(Selectors.byAttribute("name","password"));
		//--old--
		WhiteBoard = $(byId("wrapper-in"));
		LoginWindow = PageEnter.$(byClassName("login-form"));
		RegistrationWindow = $(byId("page-register"));
	}
	


	public void Login(String login, String password) {
		setLogin(LoginUserAdmin);

		LoginWindow.hover().click();
		LoginWindow.$(byAttribute("name","username")).setValue(getUser());
		LoginWindow.hover().click();
		LoginWindow.$(byAttribute("name","password")).setValue(getPassword());
		LoginWindow.hover().click();

//		LoginWindow.$(byId("email")).setValue(login);
//		LoginWindow.$(byId("password")).setValue(password);
		LoginWindow = PageEnter.$(byText("Войти")).hover();
		LoginWindow.click();

	}




	public void setLogin(final String login) {
		if (login != null) {
			final String[] s = login.split("\\|");
			if (s.length == 2) {
				user = s[0];
				password = s[1];
			}
		}
	}
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}