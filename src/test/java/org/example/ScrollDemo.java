package org.example;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends NativeBaseTest1 {

    @Test
    public void scrollDemoTest() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //method 1 the exact location where to scroll
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));


        //Method 2 scroll down until end
        //scrollToEndAction();

    }


}