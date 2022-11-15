package org.example;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

public class Main {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public DesiredCapabilities caps;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        String filePath = "D:\\mova.apk";
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName",  "OnePlus_BE2029");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", true);
        caps.setCapability("app", filePath);
        caps.setCapability("showGradleLog", true);
        caps.setCapability("appPackage", "biz.dirion.mova.dev");
      //  caps.setCapability("forceEspressoRebuild ", true);
      //  caps.setCapability("androidInstallTimeout ", 90000);
      //  caps.setCapability("androidInstallTimeout", 90000);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver,10L);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    }



    @Test
    public void basicTest() throws InterruptedException {

        //driver.findElement(MobileBy.AccessibilityId("Skip_button")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Skip_button\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Facebook_button\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Google_button\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Apple_button\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"SingIn_btn\")")).click();
        //driver.findElement(MobileBy.AccessibilityId("SingIn_btn")).click();
//        driver.findElement(AppiumBy.accessibilityId("Login_screen"));
//        driver.findElement(AppiumBy.accessibilityId("Email_textfield")).click();
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys("DirionAndroid");
//        driver.findElement(AppiumBy.accessibilityId("Password_textfield")).click();
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).sendKeys("V.KZ5UtXMUHwwM!");
//        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@content-desc=\"Login_screen\"]/*")).click();
        loginTest();
        Thread.sleep(5000L);
    }


    public void loginTest() {
        driver.findElement(MobileBy.AccessibilityId("Login_screen"));
        driver.findElement(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Email_textfield\")"))
                .sendKeys("DirionAndroid");
        driver.findElement(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Password_textfield\")"))
                .sendKeys("V.KZ5UtXMUHwwM!");
        driver.hideKeyboard();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"SignIn_btn\")")).click();
        pincodeTest();
    }

    public void pincodeTest() {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"logout_skip_tv\")")).click();
        homeTest();
    }

    public void homeTest() {
        WebElement movieList = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"movie_list\")"));

        int midOfY =movieList.getLocation().y +(movieList.getSize().height/2);
        int fromXLocation=movieList.getLocation().x + (movieList.getSize().width/2);
        int toXLocation=movieList.getLocation().x-100;

        TouchAction action =new TouchAction(driver);
        action.press(PointOption.point(fromXLocation, midOfY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(toXLocation, midOfY))
                .release()
                .perform();

        scrollDown();
    }


    public void scrollDown() {
        TouchAction  action =new TouchAction(driver);
        Dimension size	=driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.7);
        int endYCoordinate= (int)(height*.2);

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }

    public void androidScrollToAnElementByText(String text){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))")
                .click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}

