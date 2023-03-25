package com.struts2.utils;

public class CommonUtility {
	public static String convertArrayToCsv(String [] arr){
		String csv = "";
		for(String value : arr){
			csv += value+",";
		}
		return csv;
	}
	public static String[] convertCsvToArr(String csv){
		String [] values = csv.split(",");
		return values;
	}
}
