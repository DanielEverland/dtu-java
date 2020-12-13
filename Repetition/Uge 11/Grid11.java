
public class Grid11 {

	private char[][] m;
	private int n;
	
	public Grid11(int n, Data11[] m)
	{
		this.n = n < 0 ? 0 : n;
		
		this.m = new char[n][n];
		for(int x = 0; x < n; x++)
		{
			for(int y = 0; y < n; y++)
			{
				this.m[x][y] = '-';
			}
		}
		
		for(int i = 0; i < m.length; i++)
		{
			int x = m[i].getX();
			int y = m[i].getY();
			if(x < n && y < n)
				this.m[x][y] = '<';
			
			x += m[i].getDeltaX();
			y += m[i].getDeltaY();
			
			if(x < n && y < n)
				this.m[x][y] = '>';
		}
	}
	
	public String toString()
	{
		String s = "";
		for(int y = n - 1; y >= 0; y--)
		{
			for(int x = 0; x < n; x++)
			{
				s += m[x][y];
			}
			if(y > 0)
				s += "\n";
		}
		return s;
	}
}
