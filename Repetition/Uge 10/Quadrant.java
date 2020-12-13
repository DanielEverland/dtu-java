
public class Quadrant {

	private int size;
	private int[][] grid;
	
	public Quadrant(int size)
	{
		if(size < 0)
			throw new IllegalArgumentException();
		
		this.size = size;
		grid = new int[size][size];
	}
	
	public static void printTrace(Delta[] trace)
	{
		for(int i = 0; i < trace.length; i++)
			System.out.println(trace[i]);
	}
	
	public void countTrace(Delta[] trace)
	{
		int x = 0, y = 0;
		
		for(int i = 0; i < trace.length; i++)
		{
			grid[x][y]++;
			x = trace[i].newX(x);
			y = trace[i].newY(y);
			
			if(x < 0 || y < 0 || x >= size || y >= size)
				throw new IllegalArgumentException();
		}
	}
	
	public String toString()
	{
		String s = "";
		
		for(int y = size - 1; y >= 0; y--)
		{
			for(int x = 0; x < size; x++)
			{
				s += grid[x][y];
			}
			
			s += "\n";
		}
		
		return s;
	}
}
