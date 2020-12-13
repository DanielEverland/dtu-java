
public class Studerende {

	private String name;
	private Karakter[] karakterer;
	
	public Studerende(String name, int antalKarakterer)
	{
		this.name = name;
		
		if(antalKarakterer > 0)
			karakterer = new Karakter[antalKarakterer];		
	}
	
	public void karakter(int index, int tal)
	{
		if(karakterer == null || index < 1 || index > karakterer.length)
			return;
		
		karakterer[index - 1] = new Karakter(tal);
	}
	
	public String toString()
	{
		String string = name;
		
		if(karakterer == null)
			return string;
		
		for(int i = 0; i < karakterer.length; i++)
		{
			Karakter karakter = karakterer[i];
			if(karakter != null)
			{
				string += " " + karakter.toString();
			}
			else
			{
				string += " --";
			}
		}
		
		return string;
	}
}
