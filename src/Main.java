import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty(
                "webdriver.edge.driver",
                "E:\\code\\Selenium JavaScript\\chromedriver.exe");

        // Instantiate a Driver class.
        WebDriver driver = new ChromeDriver();

        Actions action = new Actions(driver);

        // Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.get("https://www.insightly.com/");

        // Create a reference
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //click on login button
        js.executeScript("document.getElementById('nav-login').click();");
        TimeUnit.SECONDS.sleep(5);

        // login credentials and submit
        js.executeScript("document.getElementById('emailaddress').value='abc@gmail.com';");
        js.executeScript("document.getElementsByName('password')[0].value='password'");
        js.executeScript("document.getElementById('login-button').click();");

        // add new task
        js.executeScript("document.getElementById('navlink_task').click();");
        TimeUnit.SECONDS.sleep(3);
        js.executeScript("document.getElementsByClassName('btn btn-danger')[0].click();");
        TimeUnit.SECONDS.sleep(3);

        // Fill the fields and save
        js.executeScript("document.getElementById('TITLE').value='Meeting';");
        js.executeScript("document.getElementById('Task_DUE_DATE').value='04-Mar-2022';");
        TimeUnit.SECONDS.sleep(2);


        WebElement saveButton = driver.findElement(By.id("btn-save"));
        js.executeScript("arguments[0].disabled = false", saveButton);
        TimeUnit.SECONDS.sleep(2);
        js.executeScript("document.getElementById('btn-save').click();");
        TimeUnit.SECONDS.sleep(2);

        // Get the details
        System.out.println("TASK REPORT");
        System.out.println("-----------------------------------------------------------");
        System.out.println(driver.findElement(By.id("entityname")).getText());
        System.out.println(driver.findElement(By.id("metadata-row-viewer-TASK_ID")).getText());
        System.out.println(driver.findElement(By.id("field-render-AssignedTo")).getText());
        System.out.println(driver.findElement(By.id("field-render-Category")).getText());
        System.out.println(driver.findElement(By.id("field-render-DateDue")).getText());
        System.out.println(driver.findElement(By.id("field-render-Reminder")).getText());
        System.out.println(driver.findElement(By.id("field-render-Repeat")).getText());
        System.out.println(driver.findElement(By.id("field-render-Progress")).getText());
        System.out.println(driver.findElement(By.id("field-render-Priority")).getText());
        System.out.println(driver.findElement(By.id("field-render-Status")).getText());
        System.out.println(driver.findElement(By.id("field-render-LastUpdated")).getText());
        System.out.println(driver.findElement(By.id("field-render-TaskCreated")).getText());
        System.out.println(driver.findElement(By.id("field-render-CreatedBy")).getText());
        System.out.println(driver.findElement(By.id("field-render-TaskOwner")).getText());

        System.out.println("_______________________________________________________________");

        driver.quit();



    }
}