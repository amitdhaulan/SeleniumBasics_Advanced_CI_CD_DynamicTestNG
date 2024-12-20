package org.example.javacore;

import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.*;
import java.util.*;

//    Creates dynamic testNG file with the user input classes
public class DynamicTestNGNew {

    protected static Properties prop;
    public static String suitName;


//    Creates dynamic testNG file with the user input classes
    public void runTestNGTest(Map<String, String> testngParams) throws IOException {

        TestNG testNGFile = new TestNG();
        XmlSuite mainSuite = new XmlSuite();

        mainSuite.setName("Regression Suite: Contains generally all the blocker test cases");
        mainSuite.setParallel(XmlSuite.ParallelMode.METHODS);

        XmlTest createStudentTest = new XmlTest(mainSuite);

        List<XmlTest> testScriptsXMLTest = new ArrayList<XmlTest>();
        List<XmlClass> testScripts = new ArrayList<XmlClass>();

        createStudentTest.setName("SecuredMobility");

        for(int i = 1; i<=testngParams.size(); i++){
            testScripts.add(new XmlClass("org.example.testscripts."+testngParams.get("class"+i)));
        }

        createStudentTest.setXmlClasses(testScripts);

        testScriptsXMLTest.add(createStudentTest);
        mainSuite.setTests(testScriptsXMLTest);

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
            /*System.out.println(new File("testngOld.xml").getAbsolutePath());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Main Method
    public static void main(String args[]) throws IOException {

//        This is used to get the user inputs: i.e. classes names and is used to generate  the XML file
        Scanner numberOfClasses = new Scanner(System.in);
        System.out.println("Enter number of classes");
        int numberOfClassesInt = numberOfClasses.nextInt();;
        Scanner myObj = new Scanner(System.in);
        DynamicTestNGNew dt = new DynamicTestNGNew();

        Map<String, String> testngParams = new HashMap<String, String>();

        for(int i = 1; i <= numberOfClassesInt; i++){
            System.out.println("Enter class Name");
            String className = myObj.nextLine();
            testngParams.put("class"+i, className);
        }

        dt.runTestNGTest(testngParams);
//       ----------------------------------------------------------------


//      This is used tp run the test cases from an existing testNG file.
       /* TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("testng.xml");
       *//* suites.add("testng1.xml");
        suites.add("testng2.xml");
        suites.add("testng3.xml");*//*
        testng.setTestSuites(suites);
        testng.run();*/
    }
}
