import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave1_StripHTML {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String filePath = input.nextLine();
		try {
			Scanner scanner = new Scanner(new File(filePath));
			stripHtmlTags(scanner);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void stripHtmlTags(Scanner scanner)
	{
		boolean isDisabled = false;
		while(scanner.hasNext())
		{
			String nextLine = scanner.nextLine();
			for(int i = 0; i < nextLine.length(); i++)
			{
				char character = nextLine.charAt(i);
				if(character == '<')
					isDisabled = true;
				
				if(!isDisabled)
					System.out.print(character);
				
				if(character == '>' && isDisabled)
					isDisabled = false;
			}
			
			System.out.println();
		}
	}
	
	private static void readEntireFile(Scanner scanner)
	{
		while(scanner.hasNextLine())
		{
			System.out.println(scanner.nextLine());
		}
	}
}
