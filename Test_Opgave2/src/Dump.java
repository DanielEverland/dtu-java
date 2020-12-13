
public class Dump {

	private int[][] square;
	
	public Dump(int size)
	{
		size = size < 0 ? 1 : size;
		square = new int[size + 2][size + 2];
	}
	
	public void update(int x, int y)
	{
		int[] cachedX = new int[8];
		int[] cachedY = new int[8];
		int[] cachedVal = new int[8];
		int neighbours = 0;
		for(int xOff = -1; xOff <= 1; xOff++)
		{
			for(int yOff = -1; yOff <= 1; yOff++)
			{
				if(xOff == 0 && yOff == 0)
					continue;
				
				int xD = x + xOff;
				int yD = y + yOff;
				
				if(xD < 0 || yD < 0 || yD > square.length || xD > square[yD].length)
					return;
				
				cachedX[neighbours] = xD;
				cachedY[neighbours] = yD;
				cachedVal[neighbours] = square[xD][yD] + 1;
				neighbours++;
			}
		}
		
		for(int i = 0; i < neighbours; i++)
		{
			square[cachedX[i]][cachedY[i]] = cachedVal[i];
		}
	}
	
	public String toString()
	{
		String s = "";
		for(int y = square.length - 1; y >= 0; y--)
		{
			for(int x = 0; x < square[y].length; x++)
			{
				s += square[x][y];
			}
			if(y > 0)
				s += "\n";
		}
		return s;
	}
}
