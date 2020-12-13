
public class Data {

	private int x;
	private int y;
	private int n;
	
	public Data(int x, int y, int n)
	{
		this.x = x > 0 ? x : 0;
		this.y = y > 0 ? y : 0;
		this.n = n > 0 ? n < 9 ? n : 9 : 0;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getN()
	{
		return n;
	}
	
	public String toString()
	{
		return x + "," + y + ":" + n;
	}
}
