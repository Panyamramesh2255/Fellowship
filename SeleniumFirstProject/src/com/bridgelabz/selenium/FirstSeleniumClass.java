package com.bridgelabz.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.opera.OperaDriver;

public class FirstSeleniumClass {
	public static void main(String[] args) {
          
		
	
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");
		//driver.close();
		
	}

}