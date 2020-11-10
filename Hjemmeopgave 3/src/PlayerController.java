import java.util.Scanner;

// Controller which is directly controlled by the player through the console
public class PlayerController extends Controller
{
	private static Scanner scanner = new Scanner(System.in);
	
	public PlayerController(GameMaster gameMaster, String name, Car toControl)
	{
		super(gameMaster, name, toControl);
	}

	public void beginTurn()
	{
		System.out.println(Name + "'s turn! Please input direction: ");
		
		int input = -1;
		do
		{			
			try
			{
				String line = scanner.nextLine();
				input = Integer.parseInt(line.strip());
			}
			catch (Exception e)
			{
				input = -1;
			}
		}
		while(!isValidInput(input));
				
		switch(input)
		{
		case 7:
			accelerateNorthWest();
			break;
		case 8:
			accelerateNorth();
			break;
		case 9:
			accelerateNorthEast();
			break;
		case 4:
			accelerateWest();
			break;
		case 5:
			moveToPrincipalPoint();
			break;
		case 6:
			accelerateEast();
			break;
		case 1:
			accelerateSouthWest();
			break;
		case 2:
			accelerateSouth();
			break;
		case 3:
			accelerateSouthEast();
			break;
		}
		
		endTurn();
	}
	
	private boolean isValidInput(int input)
	{
		return input >= 1 && input <= 9;
	}
}
