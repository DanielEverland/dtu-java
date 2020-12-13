
public class Example {

	public static void main(String[] args)
	{
		boolean m[][] = { { true, false, true }, { true, false, true }, { true, false, true } };
		System.out.println("++++++++++++");
		Grid g = new Grid(m);
		System.out.println(g);
		System.out.println("++++++++++++");
		g.swap();
		System.out.println(g);
		System.out.println("++++++++++++");
		g.swap();
		System.out.println(g);
		System.out.println("++++++++++++");
	}
}
