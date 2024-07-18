package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath = "//input[@class=\"Pke_EE\"]")
	WebElement searchComponent;

	public void searchProduct(String ProductName) {
		searchComponent.sendKeys(ProductName);
		searchComponent.sendKeys(Keys.RETURN);
	}

}
