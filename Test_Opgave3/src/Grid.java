
public class Grid {

	private Data[] a;
	
	public Grid(boolean[][] m)
	{
		int size = 0;
		for(int y = 0; y < m.length; y++)
		{
			size += m[y].length;
		}
		
		a = new Data[size];
		
		for(int x = 0; x < m.length; x++)
		{
			for(int y = 0; y < m[x].length; y++)
			{
				a[x * m.length + y] = new Data(x, y, m[x][y]);
			}
		}
	}
	
	public void swap()
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i].getZ())
				a[i].swap();
		}
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < a.length; i++)
		{
			s += a[i];
			
			if(i < a.length - 1)
				s += ";";
		}
		return s;
	}
}
