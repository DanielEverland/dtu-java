
public class Opgave3_MostFrequent {

	public static void main(String[] args)
	{
		System.out.println(mode(new int[] { 27, 15, 15, 11, 27 }));
	}
	
	private static int mode(int[] numbers)
	{
		int[][] checkedValues = new int[100][2];
		int length = 0;
		
		int currMaxIndex = -1;
		
		for(int i = 0; i < numbers.length; i++)
		{
			int currIndex = -1;
			for(int j = 0; j < length; j++)
			{
				if(checkedValues[j][0] == numbers[i])
				{
					currIndex = j;
					break;
				}
			}
			
			if(currIndex == -1)
			{				
				currIndex = length;
				checkedValues[length][0] = numbers[i];
				length++;
			}
			
			checkedValues[currIndex][1]++;
			
			if(currMaxIndex == -1)
				currMaxIndex = currIndex;
			else 
			{
				int currValue = checkedValues[currIndex][0];
				int currCount = checkedValues[currIndex][1]; 
				int currMaxValue = checkedValues[currMaxIndex][0];
				int currMaxCount = checkedValues[currMaxIndex][1];
				 
				if((currCount > currMaxCount) || (currCount == currMaxCount && currValue < currMaxValue))
					currMaxIndex = currIndex;
			}
		}
		
		if(currMaxIndex == -1)
			return -1;
		
		return checkedValues[currMaxIndex][0];
	}
}
