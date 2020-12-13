
public class Delta {

	private int a;
	private int b;
	
	public Delta(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public int newX(int val)
	{
		return a + val;
	}
	
	public int newY(int val)
	{
		return b + val;
	}
	
	public String toString()
	{
		return a + ":" + b;
	}
}
