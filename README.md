# Cucumber-Java

This is a demonstration project utilizing Maven, Java8, Selenium/WebDriver, JUnit, Lambdas and Cucumber. 

To run this demonstration user must have ChromeDriver installed and in the PATH. The ChromeDriver must match the Chrome
version installed on your local system.

## Get the code

Git:

    git clone https://github.com/binarylogik/Cucumber-Java-Selenium.git

Or [download a zip](https://github.com/binarylogik/Cucumber-Java-Selenium/archive/main.zip) file.

## Use Maven

Open a command window in the project directory and run, the default tag is full regression (@Full):

    ./mvn test

If you want to run @Smoke tests, @SignIn feature tests or @Newsletter please supply tags with maven cli:

    ./mvn test -Dcucumber.filter.tags="@Smoke"

Using Maven to execute various features:

    mvn -Dcucumber.features="src/test/resources/io.cucumber.demo/.feature" -Dcucumber.glue="io.cucumber.demo" test
