/*
 * Date: 2021/05/10
 * Name: Daniel Yuan
 * Teacher: Mr. Ho
 * Description: Use Benford's Law to analyze a sales data file 
 * 1. Read the sales.csv file
 * 2. Use Benford's law to analyze the sales data for fraud
 * 3. Export the digit frequency in a csv file with a table
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class BenfordLaw {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {

		Scanner reader = new Scanner(System.in);
		String readFile;
		String[] salesNumbers = null;

		System.out.println("Make sure your sales file is titled 'sales.csv'.");
		System.out.println("Would you like to import the sales file? (yes/no)");

		readFile = reader.nextLine();
		if (readFile.equalsIgnoreCase("yes")) {
			try {
				salesNumbers = dataReader();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println("The program has been ended");
		}
		
		
		
		if (benfordVerification(salesNumbers)) {
			System.out.println("There is a possibility you did not commit fraud! Congratulations!");
			generateSalesData(percentageCalculation(salesNumbers));
		} else {
			System.out.println(
					"Stop! You violated the law! Pay the court a fine or serve your sentence! \n Your stolen goods are now forfeit.");
		}
		
	}

	public static String[] dataReader() throws FileNotFoundException {
		String fileName = "sales.csv"; // Read the sales.csv file
		String line;
		String currentSalesAmount;
		int numLines = 0;
		String[] currentLineArray;
		File salesFile = new File(fileName);

		Scanner fileCounter = new Scanner(salesFile);
		Scanner reader = new Scanner(salesFile);

		// Read file, take second part after comma, and put in array
		// Get counter for every time a line is read, and use that number as the array
		// address/amount (skip first line)
		
		
		
		while (fileCounter.hasNext()) {
			numLines++;
			fileCounter.next();
		}

		String salesNumberArray[] = new String[numLines-2];
		
		reader.next();
		reader.next();
		
		for (int count = 0; count <= numLines-3; count++) {
			line = reader.next();
			currentLineArray = line.split("\\,"); // Reads everything from the sales.csv file after the comma delimiter
			currentSalesAmount = currentLineArray[1];
			salesNumberArray[count] = currentSalesAmount;
		}
		
		reader.close();
		System.out.println(Arrays.toString(salesNumberArray));
		return salesNumberArray;

	}
	
	public static double[] percentageCalculation(String[] salesNumberArray) {
		double percent;
		double[] dividePercentageArray = new double[9];
		double[] frequencyArray = new double[9];
		Arrays.fill(frequencyArray, 0);
		
		
		for (String sale: salesNumberArray) {
			char firstDigitChar = sale.charAt(0); // save the first character of the string
			int firstDigit = Character.getNumericValue(firstDigitChar); // reconvert to integer
			frequencyArray[firstDigit - 1]++;
		}
		
		for(int i = 0; i < 9; i++){
			percent = frequencyArray[i] / salesNumberArray.length;
			dividePercentageArray[i] = percent*100;
			
		}
		System.out.println(Arrays.toString(dividePercentageArray));
		return dividePercentageArray;
	}

	public static boolean benfordVerification(String salesNumbers[]) {
		double counter1 = 0;
		double precent = 0;
		for (int i = 0; i < salesNumbers.length; i++) {
			String saleNumbers1 = Character.toString((salesNumbers[i]).charAt(0));
			if (saleNumbers1.equals("1")) {
				counter1++;
			}
		}
		precent = (counter1 / (salesNumbers.length)) * 100;
		if (precent >= 29 && precent <= 32) {
			return true;
			
		} 
		else {
			return false;
		}
	}

	public static void generateSalesData(double[] percentageArray) {
		try{
			File salesData = new File("results.csv");
			FileWriter write = new FileWriter("results.csv");
			write.write("Number,Percent\n");
		
			
			for (int i = 1; i <= 9; i++) {
				write.write(String.format("%d, %.2f%%\n", i, percentageArray[i - 1]));
			}
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
