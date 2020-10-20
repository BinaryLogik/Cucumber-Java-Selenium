# Cucumber-Java

[![Build Status](https://travis-ci.org/cucumber/cucumber-java-skeleton.svg?branch=main)](https://travis-ci.org/cucumber/cucumber-java-skeleton)

This is a demonstration project utilizing Maven, Java8, Selenium/WebDriver, JUnit, Lambdas and Cucumber. 

To run this demonstration user must have ChromeDriver and GeckoDriver installed and in the PATH. The ChromeDriver must match the Chrome
version installed on your local system.

## Get the code

Git:

    git clone https://github.com/binarylogik/Cucumber-Java.git
    cd cucumber-java-skeleton

Or [download a zip](https://github.com/binarylogik/Cucumber-Java/archive/main.zip) file.

## Use Maven

Open a command window in the project directory and run:

    ./mvn test

This executes the Cucumber JUnit runner as specified by `@RunWith(Cucumber.class)` annotation in `RunCucumberTest` class.

Using Maven to execute all or specific features:

    mvn -Dcucumber.features="..." -Dcucumber.glue="io.cucumber.demo" test

    mvn -Dcucumber.features="src/test/resources/io.cucumber.demo/.feature" test

You can also specify what to run by *tag*:

    -Dcucumber.filter.tags="@smoketest"
