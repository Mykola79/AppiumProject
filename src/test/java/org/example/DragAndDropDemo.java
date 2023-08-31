package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropDemo extends NativeBaseTest1 {

    @Test
    public void dragDropTest(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement drag = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
        /*((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) drag).getId(),
                "endX", 815,
                "endY", 733
        ));*/
        dragAndDropAction(drag);

        String text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(text,"Dropped!");
    }
}
