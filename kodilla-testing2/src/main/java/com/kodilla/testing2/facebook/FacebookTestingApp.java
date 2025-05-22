package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FacebookTestingApp {
    public static final String XPATH_COOKIES1 = "//*[@id='facebook']/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]";
    public static final String XPATH_COOKIES2 = "//*[@id='facebook']/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]";
    public static final String XPATH_DAY = "//select[@name='birthday_day']";
    public static final String XPATH_MONTH = "//select[@name='birthday_month']";
    public static final String XPATH_YEAR = "//select[@name='birthday_year']";
    public static void main(String[] args)  {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/?locale=pl_PL");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement element = driver.findElement(By.xpath(XPATH_COOKIES1));
            element.click();
        } catch (Exception e) {

        }

        WebElement createAccountButton = driver.findElement(By.xpath("//a[contains(text(),'Utwórz nowe konto')]"));
        createAccountButton.click();

        try {
            WebElement element = driver.findElement(By.xpath(XPATH_COOKIES2));
            element.click();
        } catch (Exception e) {

        }

        WebElement day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_DAY)));
        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_MONTH)));
        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_YEAR)));

        new Select(day).selectByVisibleText("11");
        new Select(month).selectByVisibleText("sty");
        new Select(year).selectByVisibleText("1997");

    }
}