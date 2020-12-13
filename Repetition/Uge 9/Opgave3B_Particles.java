
public class Opgave3B_Particles {

	public static void main(String[] args)
	{
		Simulation x = new Simulation(10);
		x.create(0, 'A');
		x.create(7, 'B');
		System.out.println("0   1   2   3   4   5   6   7   8   9");
		System.out.println(x);
		for(int counter = 1; counter <= 9; counter++)
		{
			x.update();
			System.out.println(x + "    #" + counter);
		}
	}
}
