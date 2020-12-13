
public class Square {

	private int size;
	private Cell[][] matrix;
	
	public Square(int size, char value)
	{
		if(size < 1)
			throw new IllegalArgumentException();
		
		this.size = size;
		matrix = new Cell[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				matrix[i][j] = new Cell(value);
			}
		}
	}
	
	public void print()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				System.out.print(matrix[i][j].result());
			}
			
			System.out.println();
		}
	}
	
	public void cross()
	{
		for(int i = 0; i < size; i++)
			matrix[i][i].toggle();
	}
}
