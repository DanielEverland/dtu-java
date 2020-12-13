import java.util.Arrays;

public class Opgave3_MostFrequent_UsingSort {

	public static void main(String[] args)
	{
		System.out.println(mode(new int[] { 27, 15, 15, 11, 27 }));
	}
	
	private static int mode(int[] numbers)
	{
		Arrays.sort(numbers);
		int value = numbers[0];
		int count = 1;
		int maxCount = count;
		int maxValue = value;
		for(int i = 1; i < numbers.length; i++)
		{
			if(value != numbers[i])
			{
				if(count > maxCount)
				{
					maxCount = count;
					maxValue = value;
				}
				
				value = numbers[i];
				count = 1;
			}
			else
			{
				count++;
			}
		}
		
		return maxValue;
	}
}
