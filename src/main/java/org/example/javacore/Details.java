package org.example.javacore;

import org.example.selenium.core.BaseTest;
import org.json.JSONObject;

import java.util.Properties;

import static org.example.selenium.core.BaseTest.loadProperties;

public class Details {
    Properties prop;
    public void sendDetails(){
        prop = loadProperties("config");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("browser", prop.getProperty("browser"));
        jsonObject.put("team", prop.getProperty("team"));
        jsonObject.put("testCaseType", prop.getProperty("testCaseType"));
        jsonObject.put("PassedTestCases", BaseTest.passedTestCases.toString());
        jsonObject.put("FailedTestCases", BaseTest.failedTestCases.toString());
        jsonObject.put("SkippedTestCases", BaseTest.skippedTestCases.toString());

        System.out.println(jsonObject.toString());
    }
}
