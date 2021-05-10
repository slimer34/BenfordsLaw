/*
 * Date: 2021/05/10
 * Name: Daniel Yuan
 * Teacher: Mr. Ho
 * Description: Use Benford's Law to analyze a sales data file 
 * 1. Read the sales.csv file
 * 2. Use Benford's law to analyze the sales data for fraud
 * 3. Export the digit frequency in a csv file with a table
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; // where the [redacted] am i

class BenfordLaw {
	public static void main(String [] args) throws FileNotFoundException {
		
		String fileName = "sales.csv"; // Read the sales.csv file
		File salesFile = new File(fileName); 
		
		Scanner reader = new Scanner(salesFile);
		String[] salesNumbers = fileName.split(","); // Reads everything from the sales.csv file after the comma delimiter
		
		reader.close();
	}
	
	public static void generateSalesData(String salesChart) {
		File salesData = new File("results.csv");
		
	}
}
