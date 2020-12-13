import java.util.Scanner;

public class Opgave1_KarakterSkala
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			String nextLine = scanner.nextLine();
			try
			{
				int number = Integer.parseInt(nextLine);
				if(number == 13)
				{
					System.out.println("12");
				}
				else if(number == 11)
				{
					System.out.println("12");
				}
				else if(number == 10)
				{
					System.out.println("10");
				}
				else if(number == 9)
				{
					System.out.println("7");
				}
				else if(number == 8)
				{
					System.out.println("7");
				}
				else if(number == 7)
				{
					System.out.println("4");
				}
				else if(number == 6)
				{
					System.out.println("02");
				}
				else if(number == 5)
				{
					System.out.println("00");
				}
				else if(number == 3)
				{
					System.out.println("00");
				}
				else if(number == 0)
				{
					System.out.println("-3");
				}
			}
			catch (Exception e)
			{
				System.out.println("Couldn't convert to 12-trins skala");
			}
		}
	}
}
