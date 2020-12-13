
public class Opgave1_LastIndexOfNumber {
	
	public static void main(String[] args)
	{
		System.out.println(lastIndexOf(new int[] { 74, 85, 102, 99, 101, 85, 56 }, 8));
	}
	
	private static int lastIndexOf(int[] numbers, int target)
	{
		for(int i = numbers.length - 1; i >= 0; i--)
		{
			if(numbers[i] == target)
				return i;
		}
		
		return -1;
	}
}
