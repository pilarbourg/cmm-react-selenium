package ceu.biolab;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class SimpleSearchTest {
  private WebDriver driver;º  º
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void simplesearch() {
    driver.get("https://localhost:5178/simple-search");
    driver.findElement(By.cssSelector(".metabolites-div .box:nth-child(2)")).click();
    driver.findElement(By.cssSelector("label:nth-child(4) > .radio")).click();
    driver.findElement(By.name("tolerance")).click();
    driver.findElement(By.name("tolerance")).sendKeys("15");
    driver.findElement(By.cssSelector(".ionization-div .box:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".scrollable-checkboxes > label:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".scrollable-checkboxes > label:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".scrollable-checkboxes > label:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".checkboxes > label:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".checkboxes > label:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".checkboxes > label:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".other-buttons > .form-buttons-container:nth-child(2) > button")).click();
    driver.findElement(By.cssSelector(".form-buttons-container:nth-child(1) > button")).click();
    driver.findElement(By.cssSelector(".center-button > button")).click();
    assertThat(driver.switchTo().alert().getText(), is("There was an error submitting your search"));
    driver.findElement(By.cssSelector(".scrollable-checkboxes > label:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".scrollable-checkboxes > label:nth-child(4)")).click();
    driver.findElement(By.name("experimentalMass")).click();
    driver.findElement(By.name("experimentalMass")).sendKeys("700.00");
  }
}
