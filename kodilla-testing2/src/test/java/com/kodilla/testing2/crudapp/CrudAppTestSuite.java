package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://robdev97.github.io";
    private WebDriver driver;
    private Random generator;
    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }
    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }
    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//input[@name='title']";
        final String XPATH_TASK_CONTENT = "//textarea[@name='content']";
        final String XPATH_ADD_BUTTON = "//button[@data-task-add-button]";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(5000);

        return taskName;
    }
    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(2);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();

                });
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert says: " + alert.getText());
        alert.accept();

        Thread.sleep(5000);

    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;

        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        WebDriverWait wait = new WebDriverWait(driverTrello, Duration.ofSeconds(15));

        try {
            driverTrello.get(TRELLO_URL);

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            emailField.sendKeys("robert.lit97@gmail.com");

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Kontynuuj']/ancestor::button")));
            continueButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            passwordField.sendKeys("Zya4r36zzz1za!");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Zaloguj się']/ancestor::button")));
            loginButton.click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='board-tile']")));

            WebElement kodillaBoard = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@title='Kodilla Application']/ancestor::a")));
            kodillaBoard.click();

            WebElement thingsToDoList = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[normalize-space()='Things to do']/ancestor::div[contains(@class, 'list')]")
            ));

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//h2[normalize-space()='Things to do']/ancestor::div[contains(@class, 'list')]//span[contains(@class, 'list-card-title')]")
            ));

            java.util.List<WebElement> cards = thingsToDoList.findElements(
                    By.xpath(".//span[contains(@class, 'list-card-title')]")
            );

            for (WebElement card : cards) {
                String cardText = card.getText().trim().toLowerCase();
                System.out.println("Znaleziono kartę: " + cardText);
                if (cardText.equals(taskName.trim().toLowerCase())) {
                    result = true;
                    break;
                }
            }
        } finally {
            driverTrello.quit();
        }

        return result;
    }
    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }
}
