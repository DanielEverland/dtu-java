import java.util.Scanner;

public class Opgave4_PrintFaktorer {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		
		int n = Integer.parseInt(nextLine);
		printFaktorer(n);
		
		scanner.close();
	}
	
	private static void printFaktorer(int n)
	{
		System.out.print(1 + " _ ");
		for(int i = 2; i < n; i++)
		{
			if(n % i == 0)
				System.out.print(i + " _ ");
		}
		System.out.print(n);
	}
}
