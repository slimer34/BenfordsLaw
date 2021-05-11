/*
 * Date: 2021/11/10
 * Name: Daniel Yuan and Nikhil Sachdev
 * Teacher: Mr. Ho
 * Description: Use Benford's Law to analyze a sales data file 
 * 1. Read the sales.csv file
 * 2. Use Benford's law to analyze the sales data for fraud
 * 3. Export the digit frequency in a csv file with a table
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class BenfordLaw {
	public static void main(String [] args) throws FileNotFoundException {
		
		String fileName = "sales.csv"; // Read the sales.csv file
		File salesFile = new File(fileName); 
		
		Scanner reader = new Scanner(salesFile);
		String[] salesNumbers = fileName.split(","); // Reads everything from the sales.csv file after the comma delimiter
		
		reader.close();
	}
	
	public static boolean BenfordVerification(String salesNumbers) { //dataReader method has important stuff (including salesNumbers?)
		int counter1 = 0
		int precent = 0
		for (int i = 0; i < salesNumbers.length; i++) {
			char saleNumbers1 = (saleNumbers[i]).charAt(0);
			if (saleNumbers1.equals("1")) {
				counter1++;
			}
			else {
				continue;
			}
		}
		precent = (counter1 / (salesNumbers.length)) * 100
		if (precent >= 29 && precent <= 32) {
			return true;
		}	
		else {
			return false;
		}
	}
	
	
	public static void generateSalesData(String salesChart) {
		File salesData = new File("results.csv");
		
	}
}
