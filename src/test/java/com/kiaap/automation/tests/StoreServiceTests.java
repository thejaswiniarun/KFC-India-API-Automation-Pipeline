package com.kiaap.automation.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Core Infrastructure Validation")
@Feature("Store & Channel Services")
public class StoreServiceTests extends BaseTest {

    private final String VALID_PATH = "catalogs/15895bb59f7b4bb588ee933f8cd5344a/KFCIndiaMenu-1726-web-pickup";

    @Test(description = "TC_STR_01: Valid Store & Services")
    @Severity(SeverityLevel.NORMAL)
    @Story("Retrieve active operational status metrics from store context profiles")
    public void testValidStoreAndServices() {
        APIResponse response = requestContext.get(VALID_PATH);
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_STR_02: Authorization Header Empty")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify public endpoint routing permissions when auth elements are omitted")
    public void testAuthHeaderEmpty() {
        APIResponse response = requestContext.get(VALID_PATH, RequestOptions.create().setHeader("Authorization", ""));
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_STR_03: Unidentified Channel - DEFECT")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Intercept and handle invalid distribution configurations safely")
    @Issue("TC_STR_03")
    @Description("BUG: Channel not recognized. API should throw a 400 Bad Request but incorrectly returns a 200 OK with an empty body.")
    public void testUnidentifiedChannel() {
        APIResponse response = requestContext.get(VALID_PATH, RequestOptions.create().setHeader("X-Channel-Id", "INVALID_CHANNEL"));
        
        // INTENTIONAL FAILURE: Expecting a clean 400 rejection from a secure system
        Assert.assertNotEquals(response.status(), 200, 
                "DEFECT SPOTTED (TC_STR_03): API returned 200 OK for an unrecognized channel string instead of 400 Bad Request!");
    }

    @Test(description = "TC_STR_04: Invalid Store ID")
    @Severity(SeverityLevel.NORMAL)
    @Story("Reject malformed or non-existent store references automatically")
    public void testInvalidStoreId() {
        APIResponse response = requestContext.get(VALID_PATH + "/invalid-store-999");
        Assert.assertEquals(response.status(), 404);
    }

    @Test(description = "TC_STR_05: Invalid Service")
    @Severity(SeverityLevel.NORMAL)
    @Story("Handle unsupported fulfillment types correctly")
    public void testInvalidServiceMode() {
        APIResponse response = requestContext.get(VALID_PATH + "?serviceMode=INVALID");
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_STR_06: Missing Parameters - DEFECT")
    @Severity(SeverityLevel.MINOR)
    @Story("Protect endpoints against empty query constraints")
    @Issue("TC_STR_06")
    @Description("BUG: Response is empty payload structure. System yields a 200 OK status instead of a structural 400 Bad Request error framework block.")
    public void testMissingParameters() {
        APIResponse response = requestContext.get(VALID_PATH + "?mode=");
        
        // INTENTIONAL FAILURE: System must not pass empty query chains with 200
        Assert.assertNotEquals(response.status(), 200, 
                "DEFECT SPOTTED (TC_STR_06): System allowed empty parameter context maps with a 200 OK response!");
    }
}
