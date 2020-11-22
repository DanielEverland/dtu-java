
public class Staff
{
	public static void main(String[] Args)
	{
		Person adam = new Person();
		Boss bill = new Boss();
		Programmer carl = new Programmer();
		JavaProgrammer dean = new JavaProgrammer("Dean's code");
		JavaProgrammer eric = new JavaProgrammer("Eric's code");
		
		System.out.println(adam);
		System.out.println(bill);
		System.out.println(carl);
		System.out.println(dean);
		System.out.println(eric);
	}
}