package com.tcw.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Logger log = Logger.getLogger(BasePage.class.getName());
	public static Properties Config = new Properties();
	public FileInputStream fis;
	public static WebDriverWait wait;
	
	

	
	@BeforeSuite
	public void settingTheLogs() {
		
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		

		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			 log.info("Config Properties loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 log.info("Chrome Browser Launched !!!");
		driver.manage().window().maximize();

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));
		driver.get(Config.getProperty("testUrl"));

	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
