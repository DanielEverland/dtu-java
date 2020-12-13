
public class Particle {

	private char name;
	private int energy;
	private boolean forward;
	
	public Particle(char name)
	{
		this.name = name;
		energy = 9;
		forward = true;
	}
	
	public int step()
	{
		int returnValue = 0;		
		if(energy > 0 && forward)
			returnValue = 1;
		else if(energy > 0 && !forward)
			returnValue = -1;
		
		if(energy > 0)
			energy--;
		
		return returnValue;
	}
	
	public void reverse()
	{
		if(energy > 0)
			forward = !forward;
	}
	
	public String toString()
	{
		return "" + name + energy + (forward ? '>' : '<');
	}
}
