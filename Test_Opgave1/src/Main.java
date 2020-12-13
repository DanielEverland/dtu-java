
public class Main {

	public static void main(String[] args)
	{
		Vektor x = new Vektor("Kasper", 123456789);
		Rektor y = new Rektor("Jesper", 3.14);
		Lektor z = new Lektor("Jonathan");
		Person[] a = { x, y, z };
		printArray(a);
	}
	
	public static void printArray(Object[] a)
	{
		for(int i = 0; i < a.length; i++)
			System.out.println(i + " " + a[i]);
	}
}
