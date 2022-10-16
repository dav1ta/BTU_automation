import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Task2Tests {
  WebDriver driver;

  public Task2Tests() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--disable-dev-shm-usage");
    driver = new ChromeDriver(options);
  }

  @Test
  public void firstTest() {
    // make it headless for CI
    driver.get("https://demoqa.com/progress-bar");
    driver.manage().window().maximize();
    WebElement button = driver.findElement(By.id("startStopButton"));
    button.click();
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.textToBe(By.xpath("//*[@id='progressBar']/div"), "100%"));
    System.out.println("100%");
    driver.close();
  }

  @Test
  public void secondTest() {
    // make it headless for CI
    driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    driver.manage().window().maximize();
    WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
    Select selection = new Select(dropdown);
    selection.selectByValue("python");
    WebElement option = selection.getFirstSelectedOption();
    Assert.assertEquals(option.getText(),"Python");
    WebElement checkboxes = driver.findElement(By.id("checkboxes"));

   List<WebElement> elemens = checkboxes.findElements(By.cssSelector("input[type='checkbox']"));
    System.out.println(elemens.size());
    for (WebElement el : elemens ){
      if (!el.isSelected()){
        el.click();
      }
    }
    
    WebElement purple = driver.findElement(By.xpath("//*[@id='radio-buttons']/input[5]"));
    purple.click();
    WebElement orange = driver.findElement(By.xpath("//*[@id='fruit-selects']/option[2]"));
    Assert.assertTrue(!orange.isEnabled());
    driver.close();
  }
}
