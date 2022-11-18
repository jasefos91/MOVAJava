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

public class MovaOnboarding {
    public AndroidDriver driver;
    public WebDriverWait wait;
    public DesiredCapabilities caps;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        String filePath = "D:\\mova.apk";
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "OnePlus_BE2029");
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
        wait = new WebDriverWait(driver, 10L);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    }


    @Test
    public void TestFirstScreen() {
        //поиск текста и кнопки Скип на 1-м экране онбординга
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"The best movie streaming app of the century to make your days great!\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Welcome to Mova\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"btnSkip\")"));
        //свайп на 2-й экран онбординга
        WebElement swipeOnboarding = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"android:id/content\")"));

        int midOfY = swipeOnboarding.getLocation().y + (swipeOnboarding.getSize().height / 2);
        int fromXLocation = swipeOnboarding.getLocation().x + (swipeOnboarding.getSize().width / 2);
        int toXLocation = swipeOnboarding.getLocation().x - 300;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(fromXLocation, midOfY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(toXLocation, midOfY))
                .release()
                .perform();
        TestSecondScreen();


    }


    public void TestSecondScreen() {
        //поиск текста и кнопки Скип на 2-м экране онбординга
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Find movies quickly with tags, save your favorite movies to My list\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Convenient search\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"btnSkip\")"));
        //свайп на 3-й экран онбординга
        WebElement swipeOnboarding = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"android:id/content\")"));

        int midOfY = swipeOnboarding.getLocation().y + (swipeOnboarding.getSize().height / 2);
        int fromXLocation = swipeOnboarding.getLocation().x + (swipeOnboarding.getSize().width / 2);
        int toXLocation = swipeOnboarding.getLocation().x - 300;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(fromXLocation, midOfY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(toXLocation, midOfY))
                .release()
                .perform();
        TestThirdScreen();

    }


    public void TestThirdScreen() {
        //поиск текста и кнопки Get Started на 3-м экране онбординга
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Simple and easy\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Share your favorite movies with your friends\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"btnGetStarted\")"));
        //Тап по кнопке Get Started и переход на флоу Start Screen
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"btnGetStarted\")")).click();
        //Определение по тексту и кнопкам, что совершен переход на экран Start Screen
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Let's you in\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"btnSignIn\")"));

    }
    @Test
    public void TestTest() {
        //поиск текста и кнопки Скип на 1-м экране онбординга
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"The best movie streaming app of the century to make your days great!\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Welcome to Mova\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"Skip_button\")"));
        //свайп на 2-й экран онбординга
        WebElement swipeOnboarding = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"android:id/content\")"));

        int midOfY = swipeOnboarding.getLocation().y + (swipeOnboarding.getSize().height / 2);
        int fromXLocation = swipeOnboarding.getLocation().x + (swipeOnboarding.getSize().width / 2);
        int toXLocation = swipeOnboarding.getLocation().x - 300;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(fromXLocation, midOfY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(toXLocation, midOfY))
                .release()
                .perform();
    }
}
