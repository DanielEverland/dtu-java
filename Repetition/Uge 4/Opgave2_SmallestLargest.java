import java.util.Scanner;

public class Opgave2_SmallestLargest {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many numbers do you want to enter? ");
		int smallest = 0, largest = 0;
		int j = Integer.parseInt(scanner.nextLine());
		for(int i = 0; i < j; i++)
		{
			System.out.print("Number " + (i + 1) + ": ");
			int num = Integer.parseInt(scanner.nextLine());
			if(num < smallest)
				smallest = num;
			
			if(num > largest)
				largest = num;
		}
		
		System.out.println("Smallest: " + smallest);
		System.out.println("Largest: " + largest);
		scanner.close();
	}
}
