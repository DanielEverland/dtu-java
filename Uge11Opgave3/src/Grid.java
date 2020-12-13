
public class Grid {

	private int[][] grid;
	
	public Grid(int xSize, int ySize, Data[] data)
	{
		grid = new int[xSize][ySize];
		
		for(int i = 0; i < data.length; i++)
		{
			int x = data[i].getX();
			int y = data[i].getY();
			
			if(x >= 0 && y >= 0 && x < xSize && y < ySize)
				grid[x][y] = data[i].getN();
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
			s += "\n";
		}
		return s;
	}
}
