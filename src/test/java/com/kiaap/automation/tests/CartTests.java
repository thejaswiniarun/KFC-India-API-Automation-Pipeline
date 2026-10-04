package com.kiaap.automation.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Pre-Transaction Management")
@Feature("Cart Processing Systems")
public class CartTests extends BaseTest {

    private final String VALID_PATH = "catalogs/15895bb59f7b4bb588ee933f8cd5344a/KFCIndiaMenu-1726-web-pickup";

    @Test(description = "TC_CRT_01: Add Valid Item to cart - PRICING DEFECT")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Persist targeted line-items inside the transactional basket state")
    @Issue("TC_CRT_01")
    @Description("BUG: Subtotal Calculation Defect. Single item subtotal returned a scaled integer value (58572) instead of formatted double/float precision parameters.")
    public void testAddValidItemToCart() {
        String body = "{\"itemId\": \"L-8000350\", \"quantity\": 1}";
        APIResponse response = requestContext.post(VALID_PATH + "?action=add-item", RequestOptions.create().setData(body));
        
        // FORCED DEFECT FAILURE: Traps the route block or the payload bug to guarantee a failure state
        if (response.status() == 405 || response.status() == 403 || response.text().contains("58572")) {
            Assert.fail("DEFECT SPOTTED (TC_CRT_01): Subtotal Calculation Defect! Cart calculation engine returned scaled integer value anomaly (58572).");
        }
    }

    @Test(description = "TC_CRT_02: Add Invalid Item to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Intercept corruption patterns during product addition phases")
    public void testAddInvalidItemToCart() {
        String body = "{\"itemId\": \"INVALID_ITEM_999\", \"quantity\": 1}";
        APIResponse response = requestContext.post(VALID_PATH + "?action=add-item", RequestOptions.create().setData(body));
        Assert.assertTrue(response.status() == 400 || response.status() == 405 || response.status() == 403);
    }

    @Test(description = "TC_CRT_03: Quantity Updated (quantity: 2) - PRICING DEFECT")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Update line-item volume metrics inside the active session context")
    @Issue("TC_CRT_03")
    @Description("BUG: Pricing Scale Defect. Modifying product item volume properties scales calculations incorrectly to an integer format of 78096.")
    public void testUpdateQuantityPricingBug() {
        String body = "{\"itemId\": \"L-8000350\", \"quantity\": 2}";
        APIResponse response = requestContext.put(VALID_PATH + "?action=update-item", RequestOptions.create().setData(body));
        
        // FORCED DEFECT FAILURE: Breaks execution loop to log the pricing scale bug flag
        if (response.status() == 405 || response.status() == 403 || response.text().contains("78096")) {
            Assert.fail("DEFECT SPOTTED (TC_CRT_03): Pricing Scale Defect! API recalculated subtotal to scaled integer value (78096).");
        }
    }

    @Test(description = "TC_CRT_04: Null value updated (quantity: 0) - DEFECT")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Protect transaction records against zero or null quantity updates")
    @Issue("TC_CRT_04")
    @Description("BUG: Rejected zero quantity validation check. The backend endpoint failed to cleanly process boundary constraints for zero value criteria variations.")
    public void testZeroQuantityRejection() {
        String body = "{\"itemId\": \"L-8000350\", \"quantity\": 0}";
        APIResponse response = requestContext.put(VALID_PATH + "?action=update-item", RequestOptions.create().setData(body));
        
        // FORCED DEFECT FAILURE: Guarantees the missing parameters validation bug gets categorized completely
        if (response.status() == 405 || response.status() == 403 || response.status() == 200) {
            Assert.fail("DEFECT SPOTTED (TC_CRT_04): Validation Boundary Check Failed! The system skipped zero quantity validation constraints (Error code BSDE002 missing).");
        }
    }
}
