package com.kiaap.automation.services;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/** Shared Playwright and browser lifecycle for TestNG test classes. */
public abstract class BaseService {
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;

	@BeforeClass(alwaysRun = true)
	protected void startBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(true));
	}

	@BeforeMethod(alwaysRun = true)
	protected void createPage() {
		context = browser.newContext();
		page = context.newPage();
	}

	@AfterMethod(alwaysRun = true)
	protected void closePage() {
		page = null;
		if (context != null) {
			context.close();
			context = null;
		}
	}

	@AfterClass(alwaysRun = true)
	protected void closeBrowser() {
		if (browser != null) {
			browser.close();
			browser = null;
		}
		if (playwright != null) {
			playwright.close();
			playwright = null;
		}
	}
}
