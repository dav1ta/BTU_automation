import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTests {

  @Test
  public void firstTest() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://the-internet.herokuapp.com/");
    driver.manage().window().maximize();
    WebElement button = driver.findElement(By.xpath("//ul/li/a"));
    button.click();
    driver.navigate().back();
    WebElement button1 = driver.findElement(By.xpath("//*[@id='content']/ul/li[11]/a"));
    button1.click();
    WebElement dropdownElement = driver.findElement(By.xpath("//*[@id='dropdown']"));
    Select dropdown = new Select(dropdownElement);
    dropdown.selectByValue("1");

  }
}
