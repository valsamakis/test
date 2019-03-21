


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanasis\\Desktop\\Assignment\\chromedriver_win32\\chromedriver.exe");
    }

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void main(String[] args) throws InterruptedException {

        registration();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://calories-calc.herokuapp.com/");
        login();

        addEditDeleteRecord();


        Thread.sleep(5000);
        logout();


        Thread.sleep(5000);
        driver.quit();

    }


    static void login() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > a[href='/login'] > button")));

        WebElement element = driver.findElement(By.cssSelector("div > a[href='/login'] > button"));
        Thread.sleep(3000);
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email-input")));
        element = driver.findElement(By.cssSelector("#email-input"));
        Thread.sleep(3000);
        element.sendKeys("thanasis@nowhere.com");

        element = driver.findElement(By.cssSelector("#password-input"));
        Thread.sleep(2000);
        element.sendKeys("12345678");

        element = driver.findElement(By.cssSelector("div > input[value='Login']"));
        element.click();


    }

    static void logout() throws InterruptedException {
        // logout
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul > li[data-ui='logout-btn'] > span")));
        WebElement element = driver.findElement(By.cssSelector("ul > li[data-ui='logout-btn'] > span"));
        Thread.sleep(2000);
        element.click();

    }



    static void addEditDeleteRecord() throws InterruptedException {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > button[data-ui='add-btn']")));
        WebElement element = driver.findElement(By.cssSelector("div > button[data-ui='add-btn']"));
        element.click();

        element = driver.findElement(By.cssSelector("tr > td > input[name='name']"));
        element.sendKeys("Broccoli");

        element = driver.findElement(By.cssSelector("tr > td > input[name='calories']"));
        element.sendKeys("50");

        element = driver.findElement(By.cssSelector("tr > td > input[name='created_at']"));
        element.click();

        element = driver.findElement(By.cssSelector("td > button[data-ui='save-btn']"));
        element.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td > button[data-ui='delete-btn']")));
        List<WebElement> elements = driver.findElements(By.cssSelector("td > button[data-ui='delete-btn']"));

        //System.out.println("--------->  " + elements);
        for (int i = 0; i < elements.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td > button[data-ui='delete-btn']")));
            element = driver.findElement(By.cssSelector("td > button[data-ui='delete-btn']"));
            Thread.sleep(3000);
            element.click();
        }
        Thread.sleep(3000);


    }



    public static void registration() throws InterruptedException {

            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanasis\\Desktop\\Assignment\\chromedriver_win32\\chromedriver.exe");
            //WebDriver driver = new ChromeDriver();


            driver.get("http://calories-calc.herokuapp.com/");

            //WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > a > button")));


            WebElement element = driver.findElement(By.cssSelector("div > a[href='/register'] > button")); // element_name[<attribute_name>='<value>']
            Thread.sleep(2000);
            element.click();

            driver.findElement(By.cssSelector("#name-input")).sendKeys("thanasis");

            element = driver.findElement(By.cssSelector("#email-input"));
            element.sendKeys("thanasis@nowhere.com");
            element = driver.findElement(By.cssSelector("#password-input"));
            element.sendKeys("12345678");
            element = driver.findElement(By.cssSelector("#password-confirmation-input"));
            element.sendKeys("12345678");

            element = driver.findElement(By.cssSelector("input[type='submit']"));
            element.click();


            Thread.sleep(5000);  // Let the user actually see something!

            driver.quit();
    }

}