package com.trip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Minmax extends Init {
	
	@SuppressWarnings("deprecation")
	@Test
	public void Min(){
		List<String> productName = new ArrayList<String>();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//button[contains(text(),'OKAY, GOT IT!')]"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		List<WebElement> allProductsName = driver.findElements(By.xpath("//p[@class=\"blackText fontSize18 blackFont white-space-no-wrap\"]"));
		System.out.println("get xpath");
		for(WebElement w : allProductsName) {
		    productName.add(w.getText());
		} 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(productName);
		System.out.println("Get all price");
		int size=productName.size();
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(productName.getClass().getName());
		for(int i=0;i<size;i++)
		{
			String str=productName.get(i); 
			str = str.replaceAll("[^a-zA-Z0-9]", " "); 
			str=str.replaceAll("\\s+", "");
			int in=Integer.parseInt(str); 
			myNumbers.add(in);

		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(myNumbers);
		int max=myNumbers.get(0);
		int min=myNumbers.get(0);
		for(int i=0;i<size;i++) {
			if(max<myNumbers.get(i))
			{
				max=myNumbers.get(i);
			}
		}
		System.out.println("Max Value Is:"+ max);
		for(int i=0;i<size;i++) {
			if(min>myNumbers.get(i))
			{
				min=myNumbers.get(i);
			}
		}
		System.out.println("Min Value Is:"+ min);
		
	}

}
