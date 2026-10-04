package com.kiaap.automation.tests;

import com.microsoft.playwright.APIResponse;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Product Selection Engine")
@Feature("Menu Catalog Layouts")
public class CatalogTests extends BaseTest {

    private final String CATALOG_PATH = "catalogs/15895bb59f7b4bb588ee933f8cd5344a/KFCIndiaMenu-1726-web-pickup";

    @Test(description = "TC_CAT_01: Fetch Full Menu Catalog")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Parse layout tree matrix blocks completely")
    public void testFetchFullMenuCatalog() {
        APIResponse response = requestContext.get(CATALOG_PATH);
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_CAT_02: Fetch Valid Item Details (2 Pc Hot Wings)")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Retrieve individual item property schemas")
    public void testFetchValidItemDetails() {
        APIResponse response = requestContext.get(CATALOG_PATH + "?itemId=L-8000350");
        Assert.assertEquals(response.status(), 200);
    }

    @Test(description = "TC_CAT_03: Fetch Invalid Item ID")
    @Severity(SeverityLevel.NORMAL)
    @Story("Isolate inventory queries from non-existent item identifiers")
    public void testFetchInvalidItemId() {
        APIResponse response = requestContext.get(CATALOG_PATH + "?itemId=INVALID_ITEM_999");
        Assert.assertTrue(response.status() == 200 || response.status() == 404);
    }

    @Test(description = "TC_CAT_04: Store Item Exclusions - DEFECT")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Identify product exclusion constraints mapped dynamically per store location")
    @Issue("TC_CAT_04")
    @Description("BUG: No structured exclusions payload returned. The endpoint is throwing a 404 Not Found gateway error instead of passing empty array metadata indicators.")
    public void testStoreItemExclusions() {
        APIResponse response = requestContext.get(CATALOG_PATH + "/item-exclusions");
        
        // INTENTIONAL FAILURE: Expecting an active operational endpoint route (200 OK)
        Assert.assertEquals(response.status(), 200, 
                "DEFECT SPOTTED (TC_CAT_04): Exclusions endpoint failed to resolve and threw an unexpected 404 Not Found!");
    }

    @Test(description = "TC_CAT_05: Schema Metadata & Completeness Check")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Enforce compliance validation checks on downstream structured payloads")
    public void testSchemaMetadataCompleteness() {
        APIResponse response = requestContext.get(CATALOG_PATH);
        Assert.assertEquals(response.status(), 200);
        Assert.assertTrue(response.text().contains("products"));
    }
}
