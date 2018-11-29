package test.java.autorisations.test;

import main.java.setUp.setUP_local;
import org.testng.annotations.Test;
import test.java.autorisations.stateAutorisations.state;
import test.java.autorisations.title;

import static org.testng.Assert.assertTrue;
import static test.java.autorisations.stateAutorisations.state.Autorisation;

public class autorisations_test extends setUP_local {

    public static void autorisations_a() {

        Autorisation();

    }
    public static void autorisations_title() {

        state.title();
    }
}
