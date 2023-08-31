package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest2 {

    @Test
    public void browserTest(){

        driver.get("https://rahulshettyacademy.com/angulaAppdemo/");
        //System.out.println(driver.getTitle());


        driver.findElement(By.name("q")).sendKeys("electric zoo");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

    }


}
