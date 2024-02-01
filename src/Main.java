import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty(
                "webdriver.edge.driver",
                "E:\\code\\Selenium JavaScript\\chromedriver.exe");

        // Instantiate a Driver class.
        WebDriver driver = new ChromeDriver();



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
        System.out.println(js.executeScript("return document.evaluate('//*[@id=\"metadata-row-viewer-TITLE\"]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.innerText;"));
        System.out.println(js.executeScript("return document.getElementById('metadata-row-viewer-TASK_ID').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-AssignedTo').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-Category').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-DateDue').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-Reminder').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-Repeat').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-Progress').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-Priority').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-Status').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-LastUpdated').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-TaskCreated').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-CreatedBy').innerText;"));
        System.out.println(js.executeScript("return document.getElementById('field-render-TaskOwner').innerText;"));

        System.out.println("_______________________________________________________________");

        driver.quit();



    }
}