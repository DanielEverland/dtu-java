public class Grid {
	
	private final int size;
	private final Obs[][] grid;
	
	public Grid(int size)
	{
		this.size = size;
		this.grid = new Obs[size][size];
	}
	
	public void printValues()
	{
		for(int x = 0; x < size; x++)
		{
			for(int y = 0; y < size; y++)
			{
				Obs value = grid[x][y];
				if(value == null)
				{
					System.out.print(".");
				}
				else
				{
					System.out.print(value.getValue());
				}
			}
			
			System.out.print("\n");
		}
	}
	
	public void setCell(int x, int y, Obs cellValue)
	{
		if(x < 0 || x > size - 1 || y < 0 || y > size - 1)
			return;
		
		grid[x][y] = cellValue;
	}
}
