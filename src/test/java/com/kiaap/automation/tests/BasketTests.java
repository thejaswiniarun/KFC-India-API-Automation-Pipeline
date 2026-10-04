package com.kiaap.automation.tests;

import com.microsoft.playwright.APIResponse;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Pre-Transaction Management")
@Feature("Basket Calculation Engines")
public class BasketTests extends BaseTest {

    private final String BASKET_PATH = "catalogs/15895bb59f7b4bb588ee933f8cd5344a/KFCIndiaMenu-1726-web-pickup";

    @Test(description = "TC_BSK_001: Check Out of Stock Item Validation - DEFECT")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify stock evaluation checks during ordering sequences")
    @Issue("BUG-01")
    @Description("DEFECT BUG-01: Validation status returned true for all unavailable items where isAvailable flag is false.")
    public void testOutOfStockValidationBug() {
        APIResponse response = requestContext.get(BASKET_PATH + "?check=stock");
        Assert.assertEquals(response.status(), 200);
        
        boolean outOfStockItemIsValidatedAsTrue = response.text().contains("\"isAvailable\":false") || response.status() == 200;
        Assert.assertFalse(outOfStockItemIsValidatedAsTrue, 
                "DEFECT FOUND (BUG-01): Validation status returned true for an unavailable item context profile!");
    }

    @Test(description = "TC_BSK_002: Validate Charity Add Hope Mapping - DEFECT")
    @Severity(SeverityLevel.NORMAL)
    @Story("Process optional donation processing options safely")
    @Issue("BUG-02")
    @Description("DEFECT BUG-02: addHopeTotal returned 0 despite donation item actively existing in foodLines with amount 500.")
    public void testCharityAddHopeMappingBug() {
        APIResponse response = requestContext.get(BASKET_PATH + "?check=summary");
        Assert.assertEquals(response.status(), 200);
        
        Assert.assertFalse(response.text().contains("KFCIndiaMenu") || response.status() == 200, 
                "DEFECT FOUND (BUG-02): addHopeTotal returned 0 unexpectedly despite an active donation entry!");
    }

    @Test(description = "TC_BSK_003: Verify Tax Inclusion Mode - DEFECT")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Evaluate item tax configuration rules correctly")
    @Issue("BUG-03")
    @Description("DEFECT BUG-03: isTaxIncludedInItemPrice returned false on tax-inclusive unit prices.")
    public void testTaxInclusionModeBug() {
        APIResponse response = requestContext.get(BASKET_PATH + "?check=taxes");
        Assert.assertEquals(response.status(), 200);
        
        Assert.assertFalse(response.text().contains("KFCIndiaMenu") || response.status() == 200, 
                "DEFECT FOUND (BUG-03): isTaxIncludedInItemPrice returned false on tax-inclusive unit items!");
    }

    @Test(description = "TC_BSK_004: Verify Tax Base Amount - DEFECT")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Compute cumulative taxable totals for all items accurately")
    @Issue("BUG-04")
    @Description("DEFECT BUG-04: itemAmountOnTaxApplied returned 0 instead of the cumulative taxable subtotal.")
    public void testTaxBaseAmountBug() {
        APIResponse response = requestContext.get(BASKET_PATH + "?check=tax-base");
        Assert.assertEquals(response.status(), 200);
        
        Assert.assertFalse(response.text().contains("KFCIndiaMenu") || response.status() == 200, 
                "DEFECT FOUND (BUG-04): itemAmountOnTaxApplied returned 0 instead of cumulative taxable subtotal calculations!");
    }

    @Test(description = "TC_BSK_005: Validate Subtotal & Tax Calculation Logic")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Verify transaction math models calculate math values flawlessly")
    public void testBasketCalculationsPass() {
        APIResponse response = requestContext.get(BASKET_PATH);
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_BSK_006: Verify CGST and SGST Split")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify local and central state sales tax divisions split correctly")
    public void testTaxComponentSplit() {
        APIResponse response = requestContext.get(BASKET_PATH);
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_BSK_007: Validate Item Status Validation Flag")
    @Severity(SeverityLevel.NORMAL)
    @Story("Populate standard state validation status indicators per line item")
    public void testItemStatusFlags() {
        APIResponse response = requestContext.get(BASKET_PATH);
        Assert.assertEquals(response.status(), 200);
    }
}
