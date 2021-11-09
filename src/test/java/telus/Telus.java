package telus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.io.File;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.api.services.gmail.Gmail.Users.Drafts.List;



public class Telus {
// create global variable

private static AndroidDriver driver;

public static void main(String[] args) throws MalformedURLException, InterruptedException 
{

	DesiredCapabilities capabilities = new DesiredCapabilities();

	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android"); // Android Emulator

	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0.0");

capabilities.setCapability("appPackage", "com.optiktv");
// specify the application activity that we copied from appium                   
capabilities.setCapability("appActivity", "com.telus.mediaroom.tvx.ui.main.MainActivity");
// Start android driver I used 4727 port by default it will be 4723
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
// Specify the implicit wait of 5 second
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// Enter the text in textbox
//driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");
// click on registration button  
//driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
// Wait for 10 second
driver.findElement(By.xpath("//*[@resource-id='com.optiktv:id/enter_guest_mode']")).click();
System.out.println("Clicked on guest mode");
//captureScreenShots();
driver.findElement(By.xpath("//*[@text='On Demand']")).click();
System.out.println("Clicked at on demand");

try {
 driver.findElement(MobileBy.AndroidUIAutomator(
         "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
 System.out.println("Scrolled once");

} catch (InvalidSelectorException e) {
 // ignore
}
try {
	 driver.findElement(MobileBy.AndroidUIAutomator(
	         "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
	 System.out.println("Scrolled twice");

	} catch (InvalidSelectorException e) {
	 // ignore
	}
driver.findElement(By.xpath("//*[@text='Movies >']")).click();
System.out.println("Clicked on movies");
driver.findElement(By.xpath("//*[@text='18A']")).click();
System.out.println("Clicked on 18a asset");



//WebElement texteighteena = driver.findElement(By.xpath("//*[text()='18A | 2021 | Western |']"));
WebElement texteighteena = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]"));

if(texteighteena.isDisplayed())
{
System.out.println("18A asset found");
}
 
else
{
System.out.println("Element not found");
//driver.quit();
}

driver.findElement(By.id("backBtn")).click();
driver.quit();

//Bonus asset find or click below uncomment to execute

//driver.findElement(By.xpath("//*[@text='C8+']")).click();
//WebElement textceight = driver.findElement(By.xpath("//*[text()='C8 | 2021 | Western |']"));
//if(textceight.isDisplayed())
//{
//System.out.println("Element found using text");
//}
// 
//else
//{
//System.out.println("Element not found");
//
//}
//driver.findElement(By.xpath("//*[@text='PG']")).click();
//driver.findElement(By.xpath("//*[@text='E']")).click();
//driver.findElement(By.xpath("//*[@text='14A']")).click();
//driver.findElement(By.xpath("//*[@text='14+']")).click();
//driver.findElement(By.xpath("//*[@text='18A']")).click();
//driver.findElement(By.xpath("//*[@text='18+']")).click();
//driver.findElement(By.xpath("//*[@text='R']")).click();


Thread.sleep(2000);
// close the application
 driver.quit();
 }
}