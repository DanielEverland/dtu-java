import java.awt.geom.Point2D;
import java.awt.Color;

// A game master used for multiple-player games
public class MultiplayerGameMaster extends GameMaster
{
	private static Color[] carPathColors = new Color[]
	{
		Color.red,
		Color.blue,
		Color.green,
		Color.yellow,
	};
	
	public MultiplayerGameMaster(WorldBase world, int playerCount)
	{
		super(world);
		
		createPlayers(playerCount);
	}
	private void createPlayers(int playerCount)
	{
		for(int i = 0; i < playerCount; i++)
		{
			Point2D.Float startingPoint = World.getUnusedStartingLocation();
			
			Car car = new Car(startingPoint, carPathColors[i], World, this);
			World.registerCar(car);
			
			registerController(new PlayerController(this, "Player " + (i + 1), car));
		}
	}
}
