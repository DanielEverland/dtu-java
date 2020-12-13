
public class Opgave2B_CharGrid {

	public static void main(String[] args)
	{
		Data11 a = new Data11(1, 2, true);
		Data11 b = new Data11(7, 4, false);
		Data11 c = new Data11(-1, -1, true);
		Data11 d = new Data11(9, 0, true);
		Data11[] t = { a, b, c, d };
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		Grid11 m = new Grid11(10, t);
		System.out.println("0123456789");
		System.out.println(m);
		System.out.println("0123456789");
	}
}
