package io.cucumber.demo;

import io.cucumber.demo.helpers.DriverHelpers;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewsLetterStepDefinitions implements En {

    private WebDriver dr;

    public NewsLetterStepDefinitions() {
        
        Given("User starts at Home page", () -> {
            dr = new ChromeDriver();
            try {
                dr.get("http://automationpractice.com/index.php?");
            } catch(Exception e) {
                System.err.println("Unable to reach URL");
                throw e;
            }
            Assert.assertEquals(dr.getTitle(),"My Store");
        });

        When("User enters valid email address while signing up for" +
                " newsletter", () -> {
            dr.findElement(By.id("newsletter-input"))
                    .sendKeys("fake.jake.demo" +
                            Math.random() * 1000000000 +
                            "@gmail.com");
            dr.findElement(By.xpath("//button[@name='submitNewsletter']"))
                    .click();
        });

        When("User enters invalid email address while signing up for" +
                " newsletter", () -> {
            dr.findElement(By.id("newsletter-input"))
                    .sendKeys("bad.email");
            dr.findElement(By.xpath("//button[@name='submitNewsletter']"))
                    .click();
        });

        Then("User sees newsletter success message", (String docString) -> {
            WebElement we = DriverHelpers.waitForElement(dr,
                    By.xpath("//p[@class='alert alert-success']"));
            Assert.assertEquals(we.getText(), docString);
        });

        Then("User sees newsletter error message", (String docString) -> {
                    WebElement we = DriverHelpers.waitForElement(dr,
                            By.xpath("//p[@class='alert alert-danger']"));
            Assert.assertEquals(we.getText(), docString);
        });

        After(()->{
            if(dr != null){
                dr.quit();
            }
            dr=null;
        });

    }
}
