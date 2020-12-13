
public class Data11 {

	private int x;
	private int y;
	private boolean t;
	
	public Data11(int x, int y, boolean t)
	{
		this.x = x > 0 ? x : 0;
		this.y = y > 0 ? y : 0;
		this.t = t;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getDeltaX()
	{
		return t ? 1 : 0;
	}
	
	public int getDeltaY()
	{
		return t ? 0 : 1;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + "):" + (t ? "H" : "V");
	}
}
