package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongClick extends NativeBaseTest1 {


    @Test
    public void longClickGesture(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(ele);



        String text = driver.findElement(By.id("android:id/title")).getText();

        Assert.assertEquals(text,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());


    }
}
