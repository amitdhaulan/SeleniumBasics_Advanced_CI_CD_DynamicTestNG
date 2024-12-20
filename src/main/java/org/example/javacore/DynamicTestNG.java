/*
package org.example.javacore;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.*;
import java.util.*;




public class DynamicTestNG {

    protected static Properties prop;
    public static String suitName;

    public void runTestNGTest(Map<String, String> testngParams) throws IOException {

        TestNG testNGFile = new TestNG();
        XmlSuite mainSuite = new XmlSuite();


        mainSuite.setName("Regression Suite: Contains generally all the blocker test cases");
        mainSuite.setParallel(XmlSuite.ParallelMode.METHODS);

        XmlTest createStudentTest = new XmlTest(mainSuite);
        XmlTest loginTest = new XmlTest(mainSuite);

        List<XmlTest> createStudentXMLTest = new ArrayList<XmlTest>();
        List<XmlClass> createStudentClasses = new ArrayList<XmlClass>();

        createStudentTest.setName("SecuredMobilityCreateStudent");

        */
/*createStudentClasses.add(new XmlClass("org.example.testscripts.SecuredMobilityCreateStudent"));*//*

        createStudentClasses.add(new XmlClass("org.example.testscripts."+testngParams.get("class1")));
        createStudentTest.setXmlClasses(createStudentClasses);

        createStudentXMLTest.add(createStudentTest);
        mainSuite.setTests(createStudentXMLTest);



        loginTest.setName("SecuredMobilityLogin");
        List<XmlClass> loginClasses = new ArrayList<XmlClass>();
        loginClasses.add(new XmlClass("org.example.testscripts.SecuredMobilityLogin"));
        loginClasses.add(new XmlClass("org.example.testscripts."+testngParams.get("class2")));
        loginTest.setXmlClasses(loginClasses);

//        List<XmlTest> loginXMLTest = new ArrayList<XmlTest>();

        createStudentXMLTest.add(loginTest);
        mainSuite.setTests(createStudentXMLTest);




        List<XmlSuite> XMLSuites = new ArrayList<XmlSuite>();
        XMLSuites.add(mainSuite);

        testNGFile.setXmlSuites(XMLSuites);

        mainSuite.setFileName("testng.xml");

        mainSuite.setThreadCount(3);

        testNGFile.run();

        for (XmlSuite suite : XMLSuites)
            createXmlFile(suite);
        System.out.println("File generated successfully.");

        Map<String, String> params = createStudentTest.getParameters();
        for (Map.Entry<String, String> entry : params.entrySet())
            System.out.println(entry.getKey() + " => " + entry.getValue());

    }

    //This method will create an Xml file based on the XmlSuite data
    public void createXmlFile(XmlSuite mSuite) {
        FileWriter writer;
        try {
            writer = new FileWriter(new File("testng.xml"));
            writer.write(mSuite.toXml());
            writer.flush();
            writer.close();
            */
/*System.out.println(new File("testngOld.xml").getAbsolutePath());*//*

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Main Method
    public static void main(String args[]) throws IOException {
        ArrayList<String> classes = new ArrayList<String>();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter classes");
        String class1 = myObj.nextLine();
        classes.add(class1);

        String class2 = myObj.nextLine();
        classes.add(class2);

        DynamicTestNG dt = new DynamicTestNG();

        //This Map can hold your testng Parameters.
        Map<String, String> testngParams = new HashMap<String, String>();
        */
/*testngParams.put("device1", "Desktop");*//*


        testngParams.put("class1", class1);
        testngParams.put("class2", class2);
        dt.runTestNGTest(testngParams);

       */
/* ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"E:\\FDrive\\amit\\Projects\\MyTeam\\Members\\Neeraj Tomar\\Testing\\SecuredMobility\\AutomationScript\\SecuredMobility\" && allure serve allure-results");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }*//*

    }
}
*/
