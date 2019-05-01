import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

//driver class
public class SalesSP19Report_Valeriano {

	private static Scanner kbd;
	private static Calendar calendar;
	private static SimpleDateFormat simpleDateFormat;
	private static DateFormat dateFormat;
	private static Date currentDate;
	private static String dateString;
	private static ProductSP19_Valeriano instance;
	private static int transactionNum = 1;
	private static int day;
	
	//getting errors here, must debug to fix them
	public static void main(String[] args) {
	    calendar = Calendar.getInstance();
	    currentDate = new Date(); //instantiate Date object with no args.. sets to current date
	    calendar.setTime(currentDate); //calendar needs a date object to set time
		simpleDateFormat = new SimpleDateFormat("dd");
		dateFormat = DateFormat.getInstance();
		dateString = dateFormat.format(currentDate); //DateFormat.format(date) returns a string
		
		kbd = new Scanner(System.in);
		menuLoop();
	}
	
	//loops through the menu as long as the user wants
	private static void menuLoop()
	{
		int input;
		do
		{
			day = Integer.parseInt(simpleDateFormat.format(currentDate));
			displayMenu();
			input = kbd.nextInt();
			switch(input)
			{
			case 1:
				saleProduct();
				break;
			case 2:
				endingDayReport();
				break;
			case 3:
				endingMonthReport();
				break;
			case 4:
				endingYearReport();
				break;
			case 0:
				break;
			}
		}
		while (input != 0);
	}

	private static void displayMenu() {
		print("SALE SPRING 2019 PRODUCTS--Carlos Valeriano");
		print("Today: " + currentDate);
		print("1. Sale Product");
		print("2. Ending day sale report");
		print("3. Ending month sale report");
		print("4. Ending year sale report");
		print("0. Exit");
		print("Please enter your choice below:");
		print("");
	}
	
	//method used to make a transaction
	//first check if it's still the same day, if not then update the day to today and reset the transaction number
	//ask user for input to gather information, create an instance of data type class, then pass the information to it and call methods for printing receipt and outputting to file
	private static void saleProduct()
	{
		int sp191, sp192, sp193;
		float amountPaid;
		String transactionString;
		String fileName;
		
		if (day != Integer.parseInt(simpleDateFormat.format(currentDate)))
		{
			day = Integer.parseInt(simpleDateFormat.format(currentDate));
			transactionNum = 1;
		}

		print("-- Sale Product Transaction --");
		print("How many SP191 units were bought?");
		sp191 = inputStringAndConvertToInt();
		print("How many SP192 units were bought?");
		sp192 = inputStringAndConvertToInt();
		print("How many SP193 units were bought?");
		sp193 = inputStringAndConvertToInt();
		print("How much did the customer pay?");
		amountPaid = inputStringAndConvertToFloat();
		
		instance = new ProductSP19_Valeriano(sp191, sp192, sp193);
		transactionString = String.format("%d%04d", day, transactionNum);
		instance.printReceipt(dateString, transactionString, amountPaid);
		
		SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyymmdd");
		fileName = "DaySale_" + fileDateFormat.format(currentDate) + ".txt";
		instance.outputToDayFile(fileName, transactionString);
		
		transactionNum++;
	}

	//keep taking user input until it successfully converts to an int
	private static int inputStringAndConvertToInt() {
		boolean success = false;
		int output = 0;
		String input;
		do
		{
			input = kbd.nextLine();
			try {
			output = Integer.parseInt(input);
			success = true;
			}
			catch (NumberFormatException e)
			{
				success = false;
				print("Input not a number please try again.");
			}
		}
		while (!success);
		return output;
	}
	
	//similar to previous method but converts to a float instead
	private static float inputStringAndConvertToFloat()
	{
		boolean success = false;
		float output = 0;
		String input;
		do
		{
			input = kbd.nextLine();
			try {
			output = Float.parseFloat(input);
			success = true;
			}
			catch (NumberFormatException e)
			{
				success = false;
				print("Input not a number please try again.");
			}
		}
		while (!success);
		return output;
	}

	
	
	private static void endingDayReport()
	{
		
	}
	
	private static void endingMonthReport()
	{
		
	}
	
	private static void endingYearReport()
	{
		
	}
	
	private static void tokenizeLine()
	{
		
	}
	

	private static void print(String output)
	{
		System.out.println(output);
	}
}
