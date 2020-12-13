
public class Demo {

	public static void main(String[] args)
	{
		Dump p = new Dump(9);
		p.update(2, 2);
		p.update(2, 3);
		p.update(4, 3);
		p.update(4, 4);
		p.update(7, 9);
		p.update(0, 10);
		System.out.println("+++++++++++");
		System.out.println(p);
		System.out.println("+++++++++++");
	}
}
