package com.apex.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RemoveCharFromStringTestNG
{
	private static final java.lang.String WEBSITE_URL = "https://github.com/iappsqainterview/stringProblem";
	private static final String Google_Chrome_Path = "C:\\Users\\Sneha\\workspace\\QA\\chromedriver.exe";
	String stringdata;
	char charData;
	public String actual = null, expected = null;
	Class<Exception> expected1 = null;
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", Google_Chrome_Path);
		driver = new ChromeDriver();
		driver.get(WEBSITE_URL);
		expected = "iappsqainterview/stringProblem";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.currentThread();Thread.sleep(2000);
	}

	public void failureTests() throws Exception
	{
		expected1 = Exception.class;
		actual= driver.getTitle();
		Assert.assertEquals(actual, expected1);
		Thread.currentThread();Thread.sleep(1000);

	}

	@Test
	public void testWithSuccessCriteriaWithSimpleString() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("Hello I need to check this string!");
		driver.findElement(By.id("inputChar")).sendKeys("t");
		expected = "Hello I need o  check  his s ring!";
		actual= driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.currentThread();Thread.sleep(1000);
	}

	@Test
	public void testWithSuccessCriteriaWithDigits() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("Hello I need to 123 check this string 4!");
		driver.findElement(By.id("inputChar")).sendKeys("t");
		expected = "Hello I need o  123 check  his s ring 4!";
		actual= driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.currentThread();Thread.sleep(1000);
	}

	@Test
	public void testWithSuccessCriteriaWithNoMatchChar() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("Hello I need to 123 check this string 4!");
		driver.findElement(By.id("inputChar")).sendKeys("p");
		expected = "Hello I need to 123 check this string 4!";
		actual= driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.currentThread();Thread.sleep(1000);
	}

	@Test
	public void testWithFailureCriteriaWithoutString() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("");
		driver.findElement(By.id("inputChar")).sendKeys("t");
		failureTests();
	}

	@Test
	public void testWithFailureCriteriaWithoutChar() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("Hello I need to 123 check this string 4!");
		driver.findElement(By.id("inputChar")).sendKeys("");
		failureTests();
	}

	@Test
	public void testWithFailureCriteriaWithoutData() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("");
		driver.findElement(By.id("inputChar")).sendKeys("");
		failureTests();
	}

	@Test
	public void testWithFailureCriteriaWithNullData() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys(null);
		driver.findElement(By.id("inputChar")).sendKeys(null);
		failureTests();
	}

	@Test
	public void testWithFailureCriteriaWithDigitString() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("123");
		driver.findElement(By.id("inputChar")).sendKeys("s");
		failureTests();
	}


	@Test
	public void testWithFailureCriteriaWithDigitChar() throws Exception
	{
		driver.findElement(By.id("inputString")).sendKeys("hello I need to check this string!");
		driver.findElement(By.id("inputChar")).sendKeys("2");
		failureTests();
	}



}
