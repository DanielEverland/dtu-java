
public class Cell {
	
	private char name;
	private boolean visible;
	
	public Cell(char name)
	{
		this.name = name;
		visible = true;
	}
	
	public char result()
	{
		return visible ? name : ' ';
	}
	
	public void toggle()
	{
		visible = !visible;
	}
}
