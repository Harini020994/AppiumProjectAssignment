package framework.AppiumProject;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Demo extends Capability{
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException {
		//driver=capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		service=startServer();
		driver=capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

	@Test(priority=1)
	public void testcase1() throws IOException, InterruptedException {

		driver.findElement(By.className("android.widget.Button")).click();

	}
	
	@Test(priority=2)
	public void testcases2() throws IOException, InterruptedException {
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sign in\"))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Continue with Google\"))").click();
		Thread.sleep(10000);
		driver.findElements(By.id("com.google.android.gms:id/account_display_name")).get(0).click();
		Thread.sleep(15000);
		driver.findElement(MobileBy.AccessibilityId("Settings")).click();
	boolean isSignInSucessful=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sign out\"))").isDisplayed();
		Assert.assertEquals(isSignInSucessful, true);
		driver.findElement(MobileBy.AccessibilityId("Back")).click();
		
	}
	@Test(priority=3)
	public void testcase3() throws IOException, InterruptedException {


		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Select language\"))").click();
		driver.findElements(By.className("android.view.ViewGroup")).get(1).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))").click();
		
		driver.findElement(MobileBy.AccessibilityId("Navigate up")).click();
		
		driver.findElement(By.xpath("//*[@text='Canada']")).click();
		driver.findElement(MobileBy.AccessibilityId("Back")).click();
				
	}
	@Test(priority=4)
	public void testcase4() throws IOException, InterruptedException {

		driver.findElement(MobileBy.AccessibilityId("Settings")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sign out\"))").click();
		driver.findElement(By.id("android:id/button1")).click();
		
				
	}
	
}
