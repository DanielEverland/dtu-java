
public class Opgave4_TwoDimensionalEqual {

	public static void main(String[] args)
	{
		System.out.println(isEqual(new int[][] { {1, 2}, {2, 3} }, new int[][] { {1, 2}, {2, 3} }));
		System.out.println(isEqual(new int[][] { {1, 2}, {2, 3} }, new int[][] { {1, 2} }));
		System.out.println(isEqual(new int[][] { {1, 2}, {2, 3} }, new int[][] { {1, 2}, {2, 4} }));
	}
	
	private static boolean isEqual(int[][] a, int[][] b)
	{
		if(a.length != b.length)
			return false;
		
		int firstLength = a.length;
		for(int i = 0; i < firstLength; i++)
		{
			if(a[i].length != b[i].length)
				return false;
			
			int secondLength = a[i].length;
			for(int j = 0; j < secondLength; j++)
			{
				if(a[i][j] != b[i][j])
					return false;
			}
		}
		
		return true;
	}
}
