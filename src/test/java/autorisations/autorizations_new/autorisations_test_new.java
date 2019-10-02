package test.java.autorisations.autorizations_new;

import main.java.setUp.setUP_local_oneTest;
import org.testng.annotations.Parameters;

public class autorisations_test_new extends setUP_local_oneTest {




    @Parameters({ "user", "password" })
    public static void Autorizationss(String login, String password) {
        System.out.println("Нажимаем кнопку 'Вход и регистрация'<br>");
        User userMenu = new User();
        //userMenu.LoginAndRegistration();

        System.out.println("Заполняем поля Логин и Пароль и нажимаем кнопку Войти<br>");
        LoginRegistration loginRegistration = new LoginRegistration();
//        loginRegistration.OpenLoginWindow();
        loginRegistration.Login(login, password);
    }


    public static void test_new_auth() {
        User userMenu = new User();
        System.out.println("test_new_auth");
        userMenu.Title();
        System.out.println("test_new_auth - успешно ");
    }





}
