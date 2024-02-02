package com.mod.stepdefinitions;

import com.mod.pages.OrderDetailsPage;

import io.cucumber.java.en.And;

public class OrderDetailsStep {

	@And("Verify Load Id in Order Details Page")
	public void VerifyLoadId() {
		OrderDetailsPage.verifyLoadId();
	}
}
