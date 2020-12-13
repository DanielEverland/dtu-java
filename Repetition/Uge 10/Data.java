
public class Data {

	private String comment;
	private int[] array;
	
	public Data(String comment, int[] array)
	{
		this.comment = comment;
		this.array = array;
	}
	
	public void erase(int min, int max)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] >= min && array[i] <= max)
				array[i] = -1;
		}
	}
	
	public String toString()
	{
		String s = comment + ": ";
		for(int i = 0; i < array.length; i++)
			s += " " + array[i];
		return s;
	}
}
