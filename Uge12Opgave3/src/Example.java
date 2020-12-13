
public class Example {

	public static void main(String[] args)
	{
		Data a = new Data(1, 2, 5, false);
		Data b = new Data(1, 2, 6, false);
		Data c = new Data(3, 1, 9, true);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		Grid square = new Grid(10);
		square.line(a);
		square.line(b);
		square.line(c);
		square.line(a);
		System.out.println(square);
	}
}
