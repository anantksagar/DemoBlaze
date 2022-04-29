package com.qa.testLayer;

import org.testng.annotations.Test;
import com.qa.testBase.TestBase;

public class HomePageTest extends TestBase {


	@Test
	public void verifySamsungGalaxys6() {
		h.clickOnPhones();
		h.clickOnSamsungGalaxys6();
		util.clickOnAddToCart();
	}

	@Test
	public void verifyNokiaLumia1520() {
		h.clickOnPhones();
		h.clickOnNokiaLumia1520();
		util.clickOnAddToCart();
	}

	@Test
	public void verifyNexus6() {
		h.clickOnPhones();
		h.clickOnNexus6();
		util.clickOnAddToCart();
	}

	@Test
	public void verifyHTCOneM9() {
		h.clickOnPhones();
		h.clickOnHTCOneM9();
		util.clickOnAddToCart();
	}

	@Test
	public void verifySonyVaioi5() {
		h.clickOnPhones();
		h.clickOnSonyVaioi5();
		util.clickOnAddToCart();
	}

	@Test
	public void cerifySonyVaioi7() {
		h.clickOnPhones();
		h.clickOnSonyVaioi7();
		util.clickOnAddToCart();
	}
}
