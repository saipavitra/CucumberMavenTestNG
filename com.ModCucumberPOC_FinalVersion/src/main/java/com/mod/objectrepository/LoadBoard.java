package com.mod.objectrepository;

import com.mod.configurations.Config;

public class LoadBoard {

	//public static String legacyLoadId ="(//a[@data-aid='lb_link_loadLink'])["+(Config.testdata.get("leagcyLoadRowNum"))+"]";
	public static String legacyLoadId ="(//*[contains(@class,'p-element p-datatable-tbody')]//td//a)[1]";
	//public static String modLoadIdIcon ="(//a[starts-with(@href,'/load-board/load/')])["+(Config.testdata.get("modLoadRowNum"))+"]";
	public static String modLoadIdIcon ="(//*[contains(@class,'p-element p-datatable-tbody')]//td//a)[2]";
	
	public static String loadBoardTitle ="//div[contains(text(),'Load Board')]";
	public static String loadBoardTable ="//table[@class='p-datatable-table ng-star-inserted']";
	public static String lastLoad ="(//tr[@class='ntg-v-align-top ntg-text-pre-line break-word h-100 ng-star-inserted'])[50]";
	public static String customerClassification ="//div[contains(text(),' Customer Classification ')]";
	public static String pageLabel = "//*[contains(text(),'Load Board')]";
	public static String loadNumberLink ="//*[@data-aid='lb_link_loadLink']";
}
