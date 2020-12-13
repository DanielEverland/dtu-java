import java.util.Scanner;

public class Opgave5_AndengradsligningLøsninger {
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Angiv værdien af a: ");
		double a = scanner.nextDouble();
		
		System.out.print("Angiv værdien af b: ");
		double b = scanner.nextDouble();
		
		System.out.print("Angiv værdien af c: ");
		double c = scanner.nextDouble();
		
		System.out.println(quadratic(a, b, c));
	}
	
	private static String quadratic(double a, double b, double c)
	{
		String output = "";
		
		if(b == 0)
			throw new IllegalArgumentException("B må ikke være 0");
		
		if(a == 0)
			return "x = " + (-c / b);
		
		double d = b * b - 4 * a * c;
		
		if(d < 0)
			throw new IllegalArgumentException("Determinanten er mindre end 0");
		
		output += "x = " + ((-b + Math.sqrt(d)) / 2 * a);
		if(d > 0)
			output += ", x = " + ((-b - Math.sqrt(d)) / 2 * a);
		
		return output;
	}
}
