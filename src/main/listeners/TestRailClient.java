package main.listeners;

import com.codepine.api.testrail.TestRail;

public class TestRailClient {

    private static final String TEST_RAIL_URL = "http://testrail.ivcs.su/";
    private static final String USERNAME_TEST_RAIL = "A.Krasheninnikov@iva-tech.ru";
    private static final String PASS_TEST_RAIL = "123456";
    private static final String GLOBAL_PROJECT_TEST_RAIL = "reclection_test";

    private TestRailClient() {
    }

    public static TestRail getInstance() {
        return TestRail.builder(TEST_RAIL_URL, USERNAME_TEST_RAIL, PASS_TEST_RAIL)
                .applicationName(GLOBAL_PROJECT_TEST_RAIL)
                .build();
    }
}
