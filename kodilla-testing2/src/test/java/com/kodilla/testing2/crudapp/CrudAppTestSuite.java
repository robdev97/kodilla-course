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
import java.util.List;
import java.util.Random;


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

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@data-testid='list']")));

            List<WebElement> lists = driverTrello.findElements(By.xpath("//div[@data-testid='list']"));

            System.out.println("== LISTY NA TABLICY ==");
            for (WebElement list : lists) {
                String headerText = "BRAK NAGŁÓWKA";
                try {
                    WebElement header = list.findElement(By.xpath(".//div[@data-testid='list-header']//h2"));
                    headerText = header.getText().trim();
                } catch (Exception e) {
                    System.out.println("Nie znaleziono nagłówka dla listy.");
                }
                System.out.println("Znaleziono listę: " + headerText);

                List<WebElement> cards = list.findElements(By.xpath(".//a[contains(@class, 'list-card')]"));

                for (WebElement card : cards) {
                    String cardText = card.getText().trim();
                    System.out.println("  - karta: '" + cardText + "'");
                    if (cardText.contains(taskName)) {
                        System.out.println("ZNALEZIONO SZUKANĄ KARTĘ!");
                        result = true;
                        break;
                    }
                }
                if (result) break;
            }

        } finally {
            driverTrello.quit();
        }

        return result;
    }

    private void deleteTestTaskFromCrudApp(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        Thread.sleep(5000);

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(form -> form.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(form -> {
                    WebElement deleteButton = form.findElement(By.xpath(".//button[@data-task-delete-button]"));
                    deleteButton.click();
                });

        Thread.sleep(3000);
    }

    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteTestTaskFromCrudApp(taskName);
    }
}
