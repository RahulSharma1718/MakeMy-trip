package com.trip;

import java.util.Date; 
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Init {

	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Driver() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser name in which you want run test:");
		String str=sc.nextLine();
		if(str.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Zbook\\Desktop\\chromedriver.exe"); 
			driver=new ChromeDriver();
		}else if (str.equalsIgnoreCase("firefox")) {
			        System.setProperty("webdriver.gecko.driver","C:\\Users\\Zbook\\Desktop\\geckodriver.exe");
			        driver = new FirefoxDriver();
		}else if (str.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Zbook\\Desktop\\msedgedriver.exe");
	        driver = new EdgeDriver();
		}else {
			
			System.out.println("Please add browser");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	    String fo=formatter.format(date);
	    System.out.println(fo);
		
		driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-"+fo+"&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);   
				

	}
	@AfterTest
	public void teradown()
	{
		driver.close();
	}
}


