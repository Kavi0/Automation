package com.test.wrappers;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class GenericWrappers {

	public static WebDriver driver;
	public static Properties properties;

	@BeforeSuite
	public void genericWrappers() {

		properties = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver = new ChromeDriver();
		// driver.get(url);
		driver.get(properties.getProperty("url"));

	}

	public void usernamePasswordBox(String xpath, String data) {

		driver.findElement(By.xpath(xpath)).sendKeys(data);

	}
	
	
	public void getTextFromPage(String xpath) {
		
		System.out.println("The validation error message is: " + driver.findElement(By.xpath(xpath)).getText());
	}
	

	public void sleep(long milliseconds) {
	    try {
	        Thread.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public void assertEqualsMethod(String xpath, String expectedText) {
		
		String actualText = driver.findElement(By.xpath(xpath)).getText();
		assertEquals(actualText, expectedText);
		
	
	}
	
	
}