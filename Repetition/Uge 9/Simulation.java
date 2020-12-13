
public class Simulation {

	private int size;
	private Particle[] line;
	
	public Simulation(int size)
	{
		if(size < 0)
			throw new IllegalArgumentException();
		
		this.size = size;
		line = new Particle[size];
	}
	
	public void create(int index, char value)
	{
		if(index < 0 || index > line.length - 1 || line[index] != null)
			throw new IllegalArgumentException();
		
		line[index] = new Particle(value);
	}
	
	public void update()
	{
		for(int i = 0; i < size; i++)
		{
			Particle particle = line[i];
			if(particle != null)
			{
				int diff = particle.step();
				int newIndex = i + diff;
				
				if(newIndex > 0 && newIndex < size && line[newIndex] == null)
				{
					line[i] = null;
					line[newIndex] = particle;
				}
				else
				{
					particle.reverse();
				}
			}
		}
	}
	
	public String toString()
	{
		String s = "";
		for (int i = 0; i < size; i++)
		{
			if (line[i] != null)
			{
				s += line[i] + " ";
			}
			else
			{
				s += "    ";
			}
		}
		return s;
	}
}
