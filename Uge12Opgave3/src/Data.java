
public class Data {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private int n;
	
	public Data(int x, int y, int n, boolean t)
	{
		this.x = x < 0 ? 0 : x;
		this.y = y < 0 ? 0 : y;
		this.n = (n < 1  || n >9 ) ? 1 : n;
		this.dx = t ? 0 : 1;
		this.dy = t ? 1 : 0;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public int getN()
	{
		return n;
	}
	
	public String toString()
	{
		return x + "," + y + ":" + dx + "," + dy + ":" + n;
	}
}
