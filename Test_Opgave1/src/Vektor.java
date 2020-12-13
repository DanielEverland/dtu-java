
public class Vektor extends Person {

	private int num;
	
	public Vektor(String name, int num)
	{
		super(name);
		
		this.num = num;
	}
	
	public String toString()
	{
		return "Vektor:" + super.toString() + ";" + num;
	}
}
