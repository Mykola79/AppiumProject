package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommerceTc3 extends NativeBaseTest1 {

    @Test
    public void fillForm() throws InterruptedException {


        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("My Name");

        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        //or
        //driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //if stale element exception >
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));

        List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        //int number = products.size();
        //System.out.println("Products: "+number);

        double sum = 0;
        for (int i = 0; i < products.size(); i++) {

            String words = products.get(i).getText();
            Double price = Double.parseDouble(words.substring(1));//Double is wrapper class that converts primitive data into object
            //and string into double

            sum = sum + price;

        }
        System.out.println("Total purchase Amount: " + sum);

        String asertTotalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        //wrap text into double
        Double dispalyFormattedSum = getFormattedAmount(asertTotalAmount);

        Assert.assertEquals(sum, dispalyFormattedSum);

        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(5000);

        //now we transferred from native app to hybrid

        Set<String> contexts = driver.getContextHandles();

        for (String contextName : contexts
        ) {
            System.out.println(contextName);}


        driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver

            driver.findElement(By.name("q")).sendKeys("electric zoo");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.context("NATIVE_APP");


        }
    }




