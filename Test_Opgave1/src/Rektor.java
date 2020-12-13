
public class Rektor extends Person {

	private double num;
	
	public Rektor(String name, double num)
	{
		super(name);
		
		this.num = num;
	}
	
	public String toString()
	{
		return "Rektor:" + super.toString() + ";" + num; 
	}
}
