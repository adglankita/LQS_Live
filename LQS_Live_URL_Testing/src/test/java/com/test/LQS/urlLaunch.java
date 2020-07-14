package com.test.LQS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class urlLaunch {
	
	
	@Test
	public void test_url() {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AGL\\Desktop\\Setup\\Important_downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://lqs.co.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.close();
	}
	
	
	

}
