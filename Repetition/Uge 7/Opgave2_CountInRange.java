
public class Opgave2_CountInRange {

	public static void main(String[] args)
	{
		System.out.println(countInRange(new int[] { 14, 1, 22, 17, 36, 7, 43, 5}, 4, 17));
	}
	
	private static int countInRange(int[] numbers, int min, int max)
	{
		int count = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			if(numbers[i] >= min && numbers[i] <= max)
				count++;
		}
		
		return count;
	}
}
