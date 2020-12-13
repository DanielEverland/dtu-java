import java.util.Scanner;

public class Opgave5_BigNumberSum {

	private static final int DIGITS = 50;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("1st non-negative integer: ");
		int[] firstInteger = createBigNumber(scanner.nextLine());
		System.out.print("2nd non-negative integer: ");
		int[] secondInteger = createBigNumber(scanner.nextLine());
		
		System.out.print("Sum: ");
		int[] sum = calculateSum(firstInteger, secondInteger);
		for(int i = sum.length - 1; i >= 0; i--)
			System.out.print(sum[i]);
	}
	
	private static int[] createBigNumber(String input)
	{
		int[] digits = new int[DIGITS];
		
		int digitIndex = 0;
		for(int i = input.length() - 1; i >= 0; i--)
		{
			try
			{
				digits[digitIndex] = Integer.parseInt("" + input.charAt(i));
				digitIndex++;
			}
			catch(Exception e)
			{
			}
		}
		
		return digits;
	}
	
	private static int[] calculateSum(int[] a, int[] b)
	{
		int[] c = new int[DIGITS];
		int carry = 0;
		for(int i = 0; i < DIGITS; i++)
		{
			int rawSum = a[i] + b[i] + carry;
			carry = rawSum > 10 ? 1 : 0;
			c[i] = rawSum % 10;
		}
		
		if(carry != 0)
			throw new RuntimeException("Overflow");
		
		return c;
	}
}