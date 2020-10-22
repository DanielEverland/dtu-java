import java.util.Scanner;

public class Opgave3
{
	public static void main(String[] args)
	{		
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			WorldBase world = getWorld();
			Renderer.drawWorld(world);
			
			System.out.println("How many people are playing? Please input a number between 1 and 4");
			
			try
			{				
				int numberOfPlayers = Integer.parseInt(scanner.nextLine());
				if(numberOfPlayers >= 1 && numberOfPlayers <= 4)
				{
					GameMaster gameMaster = startMultiplayerGame(world, numberOfPlayers);					
					gameMaster.beginGame();
				}
				else
				{
					continue;
				}
			}
			catch(Exception e)
			{
				continue;
			}
			
			System.out.println("Thanks for playing! Press any button to play again.\n");
			scanner.nextLine();
		}	
	}
	
	private static WorldBase getWorld()
	{
		return new SquareWorld();
	}
	
	private static GameMaster startMultiplayerGame(WorldBase world, int playerCount)
	{
		return new MultiplayerGameMaster(world, playerCount);
	}
}