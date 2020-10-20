package io.cucumber.demo;

import io.cucumber.demo.helpers.DriverHelpers;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInStepDefinitions implements En{

    private WebDriver dr;

    public SignInStepDefinitions() {

        Given("User starts at Login page", () -> {
            dr = new ChromeDriver();
            try {
                dr.get("http://automationpractice.com/index.php?" +
                        "controller=authentication&back=my-account");
            } catch(Exception e) {
                System.err.println("Unable to reach URL");
                throw e;
            }
            Assert.assertEquals(dr.getTitle(),"Login - My Store");
        });

        When("User uses valid credentials", () -> {
            dr.findElement(By.id("email"))
                    .sendKeys("fake.jake.demo@gmail.com");
            dr.findElement(By.id("passwd")).sendKeys("FakeUser!");
            dr.findElement(By.id("SubmitLogin")).click();
        });

        When("User enters wrong password while signing in", () -> {
            dr.findElement(By.id("email"))
                    .sendKeys("fake.jake.demo@gmail.com");
            dr.findElement(By.id("passwd")).sendKeys("BADPASSWORD");
            dr.findElement(By.id("SubmitLogin")).click();
        });

        When("User enters invalid email address while signing in", () -> {
            dr.findElement(By.id("email")).sendKeys("bad.email");
            dr.findElement(By.id("passwd")).sendKeys("FakeUser!");
            dr.findElement(By.id("SubmitLogin")).click();
        });

        When("User enters incorrect email address while signing in", () -> {
            dr.findElement(By.id("email")).sendKeys("bad.email@domain.com");
            dr.findElement(By.id("passwd")).sendKeys("FakeUser!");
            dr.findElement(By.id("SubmitLogin")).click();
        });

        Then("User sees login error message {string}", (String string) -> {
                WebElement we = DriverHelpers.waitForElement(dr,
                        By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
                Assert.assertEquals(we.getText(), string);
        });

        Then("{string} page is loaded", (String string) ->
                Assert.assertEquals(dr.getTitle(),string));

        After(()->{
            if(dr != null){
                dr.quit();
            }
            dr=null;
        });
    }
}
