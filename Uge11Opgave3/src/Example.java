
public class Example {

	public static void main(String[] args)
	{
		Data a = new Data(1, 2, 1);
		Data b = new Data(7, 4, 2);
		Data c = new Data(-1, -1, 3);
		Data d = new Data(9, 0, 4);
		Data e = new Data(99, 99, 5);
		Data[] sample = { a, b, c, d, e };
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		Grid square = new Grid(10, 10, sample);
		System.out.println("----------");
		System.out.print(square);
		System.out.println("----------");
	}
}
