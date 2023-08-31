package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscellaneousAppiumActions extends NativeBaseTest1 {

    AndroidDriver driver;

    @Test
    public void miscellaneous(){

        //adb shell dumpsys wind | grep -E 'Current Focus' - Mac
        //App package and app activity
        //Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        //driver.startActivity(activity);


        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        //driver.findElement(By.id("android:id/edit")).sendKeys("My WiFi");

        String alertTitleActual = driver.findElement(By.id("android:id/alertTitle")).getText();
        String expectedTitle = "WiFi settings";
        Assert.assertEquals(alertTitleActual,expectedTitle,"Not Equal");

        //copy paste
        //copy to clipboard- paste it clipboard
        driver.setClipboardText("My WiFi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));





    }


}
