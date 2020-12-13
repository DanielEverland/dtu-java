
public class Data {

	private int x;
	private int y;
	private boolean z;
	
	public Data(int x, int y, boolean z)
	{
		this.x = x < 0 ? 0 : x;
		this.y = y < 0 ? 0 : y;
		this.z = z;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getZ()
	{
		return z;
	}
	
	public void swap()
	{
		int temp = x;
		x = y;
		y = temp;
	}
	
	public String toString()
	{
		return (z ? 'A' : 'B') + "(" + x + "," + y + ")"; 
	}
}
