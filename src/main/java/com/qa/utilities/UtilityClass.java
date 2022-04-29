package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class UtilityClass extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	private WebElement addToCart;

	public UtilityClass() {
		PageFactory.initElements(driver, this);

	}

	public void clickOnAddToCart() {
		addToCart.click();
	}

	// Taking Screenshot

	public static void takesScreenShot() {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			File dest = new File(
					"B:\\Velocitytraining\\Setup\\Eclipse_IDE_2021_12\\Eclipse_Workspace_2021_12\\DemoBlaze\\ScreenShot\\"
							+ System.currentTimeMillis() + ".png");

			FileHandler.copy(source, dest);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Exception While ScreenShot");
	
		}

	}

}
