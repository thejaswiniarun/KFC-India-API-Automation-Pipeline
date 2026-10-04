package com.kiaap.automation.tests;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse; // Added import
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Attachment; // Added import for report logging
import io.qameta.allure.Step;       // Added import for reporting steps
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected Playwright playwright;
    protected APIRequestContext requestContext;
    
    protected final String BASE_URL = "https://orderserv-kfc-apac-olo-api.yum.com/dev/v1/"; 

    @BeforeClass(alwaysRun = true)
    public void setUpAPIClient() {
        playwright = Playwright.create();
        
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
        headers.put("Connection", "keep-alive");
        
        // Corporate Firewall Validation & Whitelisting Headers
        headers.put("Origin", "https://online.kfc.co.in");
        headers.put("Referer", "https://online.kfc.co.in/");
        headers.put("app-source", "web");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/154.0.0.0 Safari/537.36");
        
        // Correlation Tokens from your session capture
        headers.put("x-correlation-request-id", "dade1f52-c8e4-4363-adb3-1f77170483e8");
        headers.put("x-correlation-session-id", "a793df62-f24a-44a4-b210-c5b3cdfe90e2");

        // Your Captured Environment Access Token
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPMTlpTGtNYnN6eHc2Wm9TejRLbDIwTEhIY1NmcVppbmZLN0p4ZkZGaVc4In0.eyJleHAiOjE3OTExMzQyNzUsImlhdCI6MTc5MTEzMDY3NSwianRpIjoiMDM0MjQ2NDItNDBiNi00OWFiLThlZWEtODExZDU2N2U3MGE2IiwiaXNzIjoiaHR0cHM6Ly9sb2dpbi5rZmMuY28uaW4vYXV0aC9yZWFsbXMva2kiLCJzdWIiOiJiNGVlNDEwOC1iYmI4LTRlZDgtODEyYi03N2I0OWJlMjBmNGYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJndWUzNHJ0NWR2bjg5bG8iLCJzZXNzaW9uX3N0YXRlIjoiNWU5MDY3ZjQtMWI3MS00NjM3LWIyMGMtNjFmNWJkNjJmODkzIiwiYWNyIjoiMSIsInNjb3BlIjoiZ3Vlc3Rfc2NvcGUgcHJvZmlsZSIsInNpZCI6IjVlOTA2N2Y0LTFiNzEtNDYzNy1iMjBjLTYxZjViZDYyZjg5MyIsIm5hbWUiOiJndWVzdC0xNzkwNjczMTE2NjcyLW90NXhoaXdpLXVsZmItb2hzZHQyMThvLTE2OWhtbHRsaGExdyBWYWxpZGF0b3IiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJndWVzdC0xNzkwNjczMTE2NjcyLW90NXhoaXdpLXVsZmItb2hzZHQyMThvLTE2OWhtbHRsaGExdyIsImdpdmVuX25hbWUiOiJndWVzdC0xNzkwNjczMTE2NjcyLW90NXhoaXdpLXVsZmItb2hzZHQyMThvLTE2OWhtbHRsaGExdyIsImZhbWlseV9uYW1lIjoiVmFsaWRhdG9yIn0.aSd1Lk6zHFvDFL5IJQ27nYL2qKxaYEotp9jGf5PJpanB6TBk8B1r2z1e1NE7Fko46Q0-0jY7J0CncjwtiIjNSxxMYBKQRzqxGpozUlzHd6o2P9vI-4EYY0ZgkSRPu4jZfZvEBevnyFSdWHLCX8yP1xA88kfRKksTMtA0Xyw_pFFUg9xacVtiB14F0EV1DwMNqsylxSa-X4srt3Wx0GKmxGZ43WCEBCYEr1-0G1uOOPKR_HSW3kc_dWJqa9jVUQpyE-0qAdDdnxOVPJ4Yq4nJ-9z5Kq9NX1wei1f2Det9_WjTCa2zxIBsVZ-UzE6jaAvmJh_zKGXA2K1OB98G_zjYmQ";
        headers.put("Authorization", "Bearer " + token);

        requestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(BASE_URL)
                .setExtraHTTPHeaders(headers));
    }

    // 🌟 HELPER STEP: Automatically shows up as a nested step inside Allure report dashboards
    @Step("Executing HTTP GET Request on endpoint: {endpoint}")
    protected APIResponse executeGet(String endpoint) {
        APIResponse response = requestContext.get(endpoint);
        attachResponseToAllure(endpoint, response);
        return response;
    }

    // 🌟 ATTACHMENT METHOD: Dumps raw response data into the report body automatically
    @Attachment(value = "API Response Log - {endpoint}", type = "application/json")
    private String attachResponseToAllure(String endpoint, APIResponse response) {
        return "Status Code: " + response.status() + "\n\nResponse Body:\n" + response.text();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAPIClient() {
        if (requestContext != null) {
            requestContext.dispose();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
