
package org.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver; 

//Browser Launch
	public static WebDriver launchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome"))  {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		}
		if(browsername.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();	
		}
		if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else {
			System.out.println("Invalid");
		}
			return driver;
	}
	
//URL Launch
	public static void urllaunch(String url) {
	driver.get(url);	
	driver.manage().window().maximize();
	}
	
//Wait
	public static void implicitwait(long time) {
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
//Title
	public static String title() {
	String title = driver.getTitle();
	return title;
	}
	
//Current URL
	public static String currentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;	
	}
	
//Close
	public static void close() {
	driver.quit();
	}
	
//SendKeys
	public static void sendkeys(WebElement txtbox,String value) {
	txtbox.sendKeys(value);
	}
	
//Click
	public static void buttonclick(WebElement btn) {
	btn.click();
	}
	
//getText
	public static String gettext(WebElement text) {
		String text2 = text.getText();
		return text2;
	}
	
//getAttributes
	public static String getAttribute(WebElement value) {
		String text = value.getAttribute("Value");
		return text;

	}
	
//Actions-moveto Element
	public static void moveToElement(WebElement loc) {
	Actions a=new Actions(driver);
	a.moveToElement(loc).perform();
	}
	
//actions-click
	public static void actionsclick(WebElement btn) {
	Actions a=new Actions(driver);
	a.click(btn);
	}
	
//actions-drag and drop
	public static void dragAndDrop(WebElement src,WebElement des) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, des);
	}
	
//actions-click and Hold
	public static void clickAndHold(WebElement src) {
		Actions a=new Actions(driver);
		a.clickAndHold(src);
	}
//actions-release
	public static void release(WebElement des) {
		Actions a=new Actions(driver);
		a.release(des);
	}
	
//actions-doubleclick
	public static void doubleclick(WebElement w) {
		Actions a=new Actions(driver);
		a.doubleClick(w);
	}
	
//actions-rightclick
	public static void contextclick(WebElement w) {
		Actions a=new Actions(driver);
		a.contextClick(w);
	}
	
//Alert-accept
	public static void accept(WebElement a) {
		driver.switchTo().alert().accept();
	}
	
//Alert-dismiss
	public static void dismiss(WebElement a) {
		driver.switchTo().alert().dismiss();
		}

//Dropdown-selectbyIndex
	public static void selectByIndex(WebElement field,int a) {
		Select s=new Select(field);
		s.selectByIndex(a);
	}

//Dropdown-selectbyValue
	public static void selectByValue(WebElement field,String optvalue) {
			Select s=new Select(field);
			s.selectByValue(optvalue);
		}
//Dropdown-selectbyVisibleTExt
	public static void selectByVisibleText(WebElement field,String text) {
			Select s=new Select(field);
			s.selectByVisibleText(text);
		}

//Dropdown-deselectbyValue
	public static void deselectByValue(WebElement field,String optvalue) {
				Select s=new Select(field);
				s.deselectByValue(optvalue);
			}
//Dropdown-deselectbyIndex
	public static void deselectByIndex(WebElement field,int a) {
			Select s=new Select(field);
			s.deselectByIndex(a);
		}

//Dropdown-deselectbyVisibleText
	public static void deselectByVisibleText(WebElement field,String optvalue) {
				Select s=new Select(field);
				s.selectByValue(optvalue);
		}
//DropDown-allvalues
	public static void getOptions(WebElement field) {
		Select s=new Select(field);
		s.getOptions();
}
//DropDown-allselectedoptions
		public static void getAllSelectedOptions(WebElement field) {
			Select s=new Select(field);
			s.getAllSelectedOptions();
	}	
//DropDown-Firstselectedoptions
		public static void getFirstSelectedOption(WebElement field) {
		Select s=new Select(field);
		s.getFirstSelectedOption();
	}	

//Takesscreenshot
		public static void takesScreenshot(String n) throws IOException {
		TakesScreenshot tk=(TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\LENOVO\\eclipse-workspace\\RealTime\\src\\test\\resources\\screenshots"+n+".png");
		FileUtils.copyFile(src, des);
		}
//javascript-sendkeys
		public static void jssendkeys(String keyvalue,WebElement w) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("argument[0].setAttribute('value',"+keyvalue+")", w);
		}
//javascript-getAttribute
		public static String jsgetAttribute(WebElement w) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object attribute = js.executeScript("argument[0].getAttribute('value')", w);
		String attributevalue=(String)attribute;
		return attributevalue;		
}


				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	



