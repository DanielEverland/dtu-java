
public class Karakter {

	private int tal;
	
	public Karakter(int tal)
	{
		if(tal != -3 && tal != 0 && tal != 2 && tal != 4 && tal != 7 && tal != 10 && tal != 12)
			throw new IllegalArgumentException(tal + " er ikke i 7-trins skalaen");
		
		this.tal = tal;
	}
	
	public String toString()
	{
		if(tal == 2)
			return "02";
		
		if(tal == 0)
			return "00";
		
		return "" + tal;
	}
}
