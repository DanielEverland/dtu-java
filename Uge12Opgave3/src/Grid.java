
public class Grid {

	private int[][] grid;
	
	public Grid(int size)
	{
		size = size > 1 ? size : 1;
		
		grid = new int[size][size];
	}
	
	public void line(Data data)
	{
		for(int i = 0; i < data.getN(); i++)
		{
			int x = data.getX() + i * data.getDX();
			int y = data.getY() + i * data.getDY();
			
			if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length)
				continue;
			
			grid[x][y] = data.getN();
		}
	}
	
	public String toString()
	{
		String s = "";
		for(int y = grid.length - 1; y >= 0; y--)
		{
			for(int x = 0; x < grid[y].length; x++)
			{
				s += grid[x][y];
			}
			s+= "\n";
		}
		return s;
	}
}
