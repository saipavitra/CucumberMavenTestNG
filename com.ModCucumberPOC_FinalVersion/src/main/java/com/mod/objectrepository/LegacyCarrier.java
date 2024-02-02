package com.mod.objectrepository;
import com.mod.pages.LegacyCarrierPage;

public class LegacyCarrier {

	public static String txtbxFromPowerUnit="//input[@id='MainContent_PowerUnitsFromTB']";
	public static String txtbxToPowerUnit="//input[@id='MainContent_PowerUnitsToTB']";
	public static String btnSearchCarrier="//input[@value='Search Carriers']";
	public static String lnkCarrier="//a[@id='MainContent_SearchCarriersGrid_cell0_1_SearchCarriersGridNameHL_"+LegacyCarrierPage.carrierIndex+"']";
	public static String btnQuickAdd="//a[@id='MainContent_carrierProfileTabControl_lbtnQuickAdd']";
	public static String btnEditDriver="//*[@id='pr_id_2-table']/tbody/tr[1]/td[8]/div/div[1]/button";
	public static String txtbxPrimaryphone="//label[@for='primaryPhone']//following::input[1]";
	public static String btnSave="//*[contains(text(),'Save')]";
	public static String txtfirstPrimaryphone="//*[@id='pr_id_2-table']/tbody/tr[1]/td[4]/a";
	public static String tblDriverContact="//table[@class='p-datatable-table ng-star-inserted']";
	public static String dialogEdit="//*[@id='contentContainer md:col-12']/ntg-carrier-carrier-details/div/ntg-carrier-carrier-contact/p-dialog[4]/div/div";
	public static String txtbxCarrierName="//*[@id='MainContent_CarrierNameTB']";
	public static String txtbxEmail="(//input[@type='email'])[1]";
	//public static String lblPrimaryPhone="//*[contains(text(),'Primary Phone')]";
	
	public static String lblPrimaryPhone="(//*[contains(@class,'p-element p-datatable-tbody')]//td)[5]";
}
