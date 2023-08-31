package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumBasics extends NativeBaseTest1 {



    @Test
    public void wiFiSettingName() throws MalformedURLException {



        //code to start server
            //AndroidDriver, OISDriver
            //Appium code --> Appium Server --> Mobile
            //Actual Automation
            //Xpath, id, accessibilityId, className, androidUiAutomator

        //tagName[@attrubute='value']

        //configureAppium();
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        //driver.findElement(By.id("android:id/edit")).sendKeys("My WiFi");

        String alertTitleActual = driver.findElement(By.id("android:id/alertTitle")).getText();
        String expectedTitle = "WiFi settings";
        Assert.assertEquals(alertTitleActual,expectedTitle,"Not Equal");

        driver.findElement(AppiumBy.id("android:id/button1")).click();


    }
}
