
public class Opgave2B_Quadrant {

	public static void main(String[] args)
	{
		Delta n = new Delta(0, 1);
		Delta e = new Delta(1, 0);
		Delta s = new Delta(0, -1);
		Delta w = new Delta(-1, 0);
		Delta[] array = { n, e, s, w };
		Quadrant q = new Quadrant(3);
		System.out.println(q);
		q.countTrace(array);
		System.out.println(q);
		q.countTrace(array);
		System.out.println(q);
		Quadrant.printTrace(array);
	}
}
