package com.stepdefenition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefiniton {
	
	WebDriver driver;
	


	
	@Given("user is on Flipkart page")
	public void user_is_on_flipkart_page() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize(); 
	}

	@Then("user should search the laptop in search bar")
	public void user_should_search_the_laptop_in_search_bar() {
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Laptop");
		driver.findElement(By.xpath("//button[@class = '_2iLD__']")).click();
	}

	@Then("user should get the laptop details")
	public void user_should_get_the_laptop_details() {
		

		
		String expected = "Laptops";
		String actual = driver.findElement(By.xpath("//a[@class='_1jJQdf _2Mji8F' and text()='Laptops' ]")).getText();
		Assert.assertEquals(expected, actual);
	  
		driver.findElement(By.xpath("//div[text()='Acer Aspire 3 Intel Core i3 12th Gen 1215U - (8 GB/512 GB SSD/Windows 11 Home) A315-59 Thin and Light ...']")).click();
	}

	@Then("user should add the laptop product to the shopping cart")
	public void user_should_add_the_laptop_product_to_the_shopping_cart() throws InterruptedException {
	  
		Set <String> handles = driver.getWindowHandles();
		  Iterator it = handles.iterator();
		  String parentid=(String) it.next();
		  String childid=(String) it.next();
		  driver.switchTo().window(childid);
		
		WebElement cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", cart);
		
		String expected1 = "ADD TO CART";
		String actual1 = driver.findElement(By.xpath("//button [text()='Add to cart']")).getText();
		Assert.assertEquals(expected1, actual1);
				
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww' and text()='Add to cart' ]")).click();	}

	@Then("user should verify the item in cart")
	public void user_should_verify_the_item_in_cart() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String expected2 = "PLACE ORDER";
		String actual2 = driver.findElement(By.xpath("//span[text()='Place Order']")).getText();
		Assert.assertEquals(expected2, actual2);
	}

	@When("user should click on Proceed to Checkout botton")
	public void user_should_click_on_proceed_to_checkout_botton() {
	    driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2ObVJD _3AWRsL']")).click();
	}


	@And("user should quit the browser")
	public void user_should_quit_the_browser() {
	    driver.quit();
	    System.out.println("Hi There,\r\n" + 
	    		"\r\n" + 
	    		"In Flipkart, Login page requires OTP to login. We cannot bypass login without OPT.\r\n" + 
	    		"So, I stopped automation upto login page. \r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"Thanks & Regards,\r\n" + 
	    		"Ajithsingh P");
	}
}
