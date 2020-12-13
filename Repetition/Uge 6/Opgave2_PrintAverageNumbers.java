import java.io.*;
import java.util.*;

public class Opgave2_PrintAverageNumbers {
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter full path to input file: ");
		File inputFile = new File(scanner.nextLine());
		
		int sum = 0, amount = 0, min = 0, max = 0;
		
		try {
			Scanner fileScanner = new Scanner(inputFile);
			while(fileScanner.hasNext())
			{
				try
				{
					Integer number = Integer.parseInt(fileScanner.next());
					
					sum += number;
					amount++;
					
					if(number < min || amount == 1)
						min = number;
					
					if(number > max || amount == 1)
						max = number;
				}
				catch (Exception e)
				{
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Average: " + ((float)sum / amount));
		System.out.println("Max : " + max + " Min: " + min);
	}
}
