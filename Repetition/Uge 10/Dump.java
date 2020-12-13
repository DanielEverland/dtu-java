
public class Dump {

	private Data[] data;
	
	public Dump(Data[] data, int min, int max)
	{
		this.data = data;
		
		for(int i = 0; i < data.length; i++)
			data[i].erase(min, max);
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < data.length; i++)
		{
			s += data[i].toString() + "\n";
		}
		s+= "----";
		return s;
	}
}
