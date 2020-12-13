
public class Opgave3B_Studerende {

	public static void main(String[] args)
	{
		Studerende s123 = new Studerende("Einstein", 5);
		s123.karakter(1,  12);
		s123.karakter(2, 10);
		s123.karakter(4, 0);
		s123.karakter(5, -3);
		System.out.println(s123);
		Studerende s999 = new Studerende("Miss Take", -1);
		s999.karakter(0, 7);
		System.out.println(s999);
	}
}
