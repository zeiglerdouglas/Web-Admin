package test.java.blackMagic;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Plan;
import main.java.annotations.TestRailId;
import main.java.setUp.setUP_local;
import main.listeners.TestRailClient;
import org.reflections.Reflections;
import org.testng.IAlterSuiteListener;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.util.*;

public class GenerateXmlForTestRailListener implements IAlterSuiteListener {

    @Override
    public void alter(List<XmlSuite> list) {
        List<TestClass> runTestClassList = new ArrayList<TestClass>();
        List<TestClass> allTestClassList = getTestClassList();

        TestRail testRail = TestRailClient.getInstance();
        List<Plan.Entry.Run> runList = testRail.plans().get(getPlanId()).execute().getEntries().get(0).getRuns();
        for (Plan.Entry.Run run : runList) {
//            String platform = run.getConfig().get(0);
            String platform = run.getConfig().get(0);
            List<com.codepine.api.testrail.model.Test> testList = testRail.tests().list(run.getId()).execute();

            for (com.codepine.api.testrail.model.Test test : testList) {
                int caseId = test.getCaseId();
//                int caseId = test.setStatusId(1);
                String tlId = String.valueOf(test.getCustomFields().get("tlref"));
                int version = Integer.valueOf(String.valueOf(test.getCustomFields().get("tlver")));

                for (TestClass testClass : allTestClassList) {
                    if (getPlatformNameByGroup(testClass.getGroup()).equals(platform)
                            && ((testClass.getTrId() != null && Integer.parseInt(testClass.getTrId()) == caseId)
                            && Integer.parseInt(testClass.getVersion()) == version)) {
                        runTestClassList.add(testClass);
                    }
                }
            }
        }


        if (!list.isEmpty()) {
            XmlSuite modifiedSuite = list.get(0);

            for (TestClass testClass : runTestClassList) {
                XmlTest xmlTest = new XmlTest(modifiedSuite);
                String platform = getPlatformNameByGroup(testClass.getGroup());
                xmlTest.setName(platform + ":" + testClass.getTrId());
                xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(testClass.getClassPath())));
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("platform", platform);
                xmlTest.setParameters(parameters);

                List<String> includedGroups = Collections.singletonList(getGroupByPlatformName(platform));
                xmlTest.setIncludedGroups(includedGroups);

                List<String> excludedGroups = getAllGroups();
                excludedGroups.removeAll(includedGroups);
                xmlTest.setExcludedGroups(excludedGroups);
            }

            System.out.println(modifiedSuite.toXml());
            System.out.println("модификация XML");
            System.out.println("/t---/t");
            System.out.println("/t---/t");
        }

    }

    private List<TestClass> getTestClassList() {
        List<TestClass> testClassList = new ArrayList<TestClass>();
        Reflections reflections = new Reflections(".*");
        Set<Class<? extends setUP_local>> allClasses = reflections.getSubTypesOf(setUP_local.class);
        Iterator<Class<? extends setUP_local>> classIterator = allClasses.iterator();
        while (classIterator.hasNext()) {
            Class<? extends setUP_local> next = classIterator.next();
            Method[] methods = next.getMethods();
            for (Method method : methods) {
                Test testAnnotation = method.getAnnotation(Test.class);
                if (testAnnotation == null) {
                    continue;
                }

                testClassList.add(getTestClass(next, method));
            }
        }
        return testClassList;
    }

    private TestClass getTestClass(Class<? extends setUP_local> next, Method method) {
        String trId = null;
        String tlId = null;
        String version = null;
        String group = getGroupForTestMethod(method);
        String classPath = next.getName();

        TestRailId testRailIdAnnotation = method.getAnnotation(TestRailId.class);
        if (testRailIdAnnotation != null) {
            trId = testRailIdAnnotation.id();
            version = testRailIdAnnotation.version();
        }

//        TestLink testLinkAnnotation = method.getAnnotation(TestLink.class);
//        if (testLinkAnnotation != null) {
//            tlId = testLinkAnnotation.testCaseId();
//            version = testLinkAnnotation.testCaseVersion();
//        }

        return new TestClass(trId, tlId, version, group, classPath);
    }

    private String getGroupForTestMethod(Method method) {
        Test test = method.getAnnotation(Test.class);
        if (test != null) {
            for (String group : test.groups()) {
                if (getAllGroups().contains(group)) {
                    return group;
                }
            }
        }
        return "";
    }

    private class TestClass {
        private final String trId;
        private final String tlId;
        private final String version;
        private final String group;
        private final String classPath;

        public TestClass(String trId, String tlId, String version, String group, String classPath) {
            this.trId = trId;
            this.tlId = tlId;
            this.version = version;
            this.group = group;
            this.classPath = classPath;
        }

        public String getTrId() {
            return trId;
        }

        public String getTlId() {
            return tlId;
        }

        public String getVersion() {
            return version;
        }

        public String getGroup() {
            return group;
        }

        public String getClassPath() {
            return classPath;
        }
    }

    private String getTestPlan() {
        return System.getenv("TEST_PLAN");
    }

    private String getPlatform() {
        String platforms = System.getenv("IVA Codec");
        if (platforms != null && !platforms.isEmpty()) {
            return String.valueOf(Integer.parseInt(platforms));
        } else {
            throw new RuntimeException("Param 'IVA Codec' should be set");
        }
//        return System.getenv("IVA Codec");
    }



    private int getPlanId() {
        String trPlanId = "5148";

//1539 5762 6640
//        String trPlanId = System.getenv("TR_PLAN_ID");
        if (trPlanId != null && !trPlanId.isEmpty()) {
            return Integer.parseInt(trPlanId);
        } else {
            throw new RuntimeException("Param 'TR_PLAN_ID' should be set");
        }
    }


    private String getGroupByPlatformName(String platformName) {
        if (platformName.equals("авторизация")) {
            return "авторизация";
        }
        if (platformName.equals("leftPanel")) {
            return "leftPanel";
        }
        if (platformName.equals("menuConsole")) {
            return "menuConsole";
        }
        if (platformName.equals("menuJurnal")) {
            return "menuJurnal";
        }
        if (platformName.equals("menuProperites")) {
            return "menuProperites";
        }
        if (platformName.equals("menuService")) {
            return "menuService";
        }
        if (platformName.equals("menuSystem")) {
            return "menuSystem";
        }
        if (platformName.equals("upsidePanel")) {
            return "upsidePanel";
        }
//        if (platformName.equals("Охрана труда")) {
//            return "ehs";
//        }
//        if (platformName.equals("Образование")) {
//            return "edu";
//        }
//        if (platformName.equals("ЭЛПУ")) {
//            return "elpu";
//        }
//        if (platformName.equals("КЛПУ")) {
//            return "klpu";
//        }
//        if (platformName.equals("УМД")) {
//            return "umd";
//        }
//        if (platformName.equals("Культура")) {
//            return "cult";
//        }
//        if (platformName.equals("ГЛМС")) {
//            return "glms";
//        }
//        if (platformName.equals("ГЛВ")) {
//            return "glv";
//        }
//        if (platformName.equals("Expertus:GB")) {
//            return "expertus_gl";
//        }
//        if (platformName.equals("Expertus.Kadry")) {
//            return "expertus_k";
//        }
//        if (platformName.equals("Expertus.Med")) {
//            return "expertus_med";
//        }
//        if (platformName.equals("Actualis.KD")) {
//            return "actualis_k";
//        }
//        if (platformName.equals("Actualis.Obraz")) {
//            return "actualis_edu";
//        }
//        if (platformName.equals("Actualis:GB")) {
//            return "actualis_gl";
//        }
//        if (platformName.equals("Actualis:GZ")) {
//            return "actualis_gz";
//        }
//        if (platformName.equals("Actualis.Med")) {
//            return "actualis_med";
//        }
        return "";
    }

    private String getPlatformNameByGroup(String group) {
        if (group.equals("авторизация")) {
            return "авторизация";
        }
        if (group.equals("leftPanel")) {
            return "leftPanel";
        }
        if (group.equals("menuConsole")) {
            return "menuConsole";
        }
        if (group.equals("menuJurnal")) {
            return "menuJurnal";
        }
        if (group.equals("menuProperites")) {
            return "menuProperites";
        }
        if (group.equals("menuService")) {
            return "menuService";
        }
        if (group.equals("menuSystem")) {
            return "menuSystem";
        }
        if (group.equals("upsidePanel")) {
            return "upsidePanel";
        }
//        if (group.equals("ehs")) {
//            return "Охрана труда";
//        }
//        if (group.equals("edu")) {
//            return "Образование";
//        }
//        if (group.equals("elpu")) {
//            return "ЭЛПУ";
//        }
//        if (group.equals("klpu")) {
//            return "КЛПУ";
//        }
//        if (group.equals("umd")) {
//            return "УМД";
//        }
//        if (group.equals("cult")) {
//            return "Культура";
//        }
//        if (group.equals("glms")) {
//            return "ГЛМС";
//        }
//        if (group.equals("glv")) {
//            return "ГЛВ";
//        }
//        if (group.equals("expertus_gl")) {
//            return "Expertus:GB";
//        }
//        if (group.equals("expertus_k")) {
//            return "Expertus.Kadry";
//        }
//        if (group.equals("expertus_med")) {
//            return "Expertus.Med";
//        }
//        if (group.equals("actualis_k")) {
//            return "Actualis.KD";
//        }
//        if (group.equals("actualis_edu")) {
//            return "Actualis.Obraz";
//        }
//        if (group.equals("actualis_gl")) {
//            return "Actualis:GB";
//        }
//        if (group.equals("actualis_gz")) {
//            return "Actualis:GZ";
//        }
//        if (group.equals("actualis_med")) {
//            return "Actualis.Med";
//        }
        return "";
    }

    private List<String> getAllGroups() {
        List<String> groups = new ArrayList<String>();
        groups.add("авторизация");
        groups.add("leftPanel");
        groups.add("menuConsole");
        groups.add("menuJurnal");
        groups.add("menuProperites");
        groups.add("menuService");
        groups.add("menuSystem");
        groups.add("upsidePanel");
        //-- old --
//        groups.add("ehs");
//        groups.add("edu");
//        groups.add("elpu");
//        groups.add("klpu");
//        groups.add("umd");
//        groups.add("cult");
//        groups.add("glms");
//        groups.add("glv");
//        groups.add("expertus_gl");
//        groups.add("expertus_k");
//        groups.add("expertus_med");
//        groups.add("actualis_k");
//        groups.add("actualis_edu");
//        groups.add("actualis_gl");
//        groups.add("actualis_gz");
//        groups.add("actualis_med");
        return groups;
    }

}
