
public class Opgave3B_DataDump {

	public static void main(String[] args)
	{
		System.out.println("++++");
		int[] x = { 10, 21, 32, 43 };
		int[] y = { 11, 22, 23, 44 };
		Data one = new Data("Data 1", x);
		Data two = new Data("Data 2", y);
		Data[] experiment = { one, two };
		Dump p = new Dump(experiment, 20, 30);
		System.out.println(p);
		Dump q = new Dump(experiment, 30, 40);
		System.out.println(p);
		System.out.println(q);
		System.out.println("++++");
	}
}
