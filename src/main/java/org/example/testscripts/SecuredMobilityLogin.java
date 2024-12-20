package org.example.testscripts;


import io.qameta.allure.*;
import org.example.Listener.ReportListener;
import org.example.selenium.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("#42440")
@Feature("Reporting")
@Story(" ===== Will be added after discussing")
@Owner("Amit Kashyap")
@Severity(SeverityLevel.BLOCKER)

@Listeners(value= ReportListener.class)
public class SecuredMobilityLogin extends BaseTest {

    public SecuredMobilityLogin() {
        super();
    }

    @Test(groups ={"smoke"}, priority = 0)
    public void LoginTestCase() {
        System.out.println("Added a system out");
    }
}