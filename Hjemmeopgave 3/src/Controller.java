import java.awt.geom.Point2D;

// Base class for controlling a car
public abstract class Controller
{
	public Controller(GameMaster gameMaster, String name, Car toControl)
	{
		this.gameMaster = gameMaster;
		this.Name = name;
		this.controllingCar = toControl;
	}
	
	// Name of the player
	public final String Name;
	
	private final GameMaster gameMaster;
	private final Car controllingCar;
	
	private int turnsTaken = 0;
	private boolean isActive = true;
	
	// Tells the controller it is their turn to perform an action.
	public abstract void beginTurn();
	
	public int getTurnsTaken()
	{
		return turnsTaken;
	}
	
	public boolean getIsActive()
	{
		return isActive;
	}
	
	// This happens when a given player has been removed from the game, for instance due to crashing.
	public void disable()
	{
		isActive = false;
	}
	
	// Call this when an action has been performed, and this controller's turn has ended.
	protected void endTurn()
	{
		turnsTaken = getTurnsTaken() + 1;
		gameMaster.controllerTurnEnded(this);
	}
	
	protected void accelerateNorthWest()
	{
		controllingCar.move(new Point2D.Float(-1, 1));
	}
	
	protected void accelerateNorth()
	{
		controllingCar.move(new Point2D.Float(0, 1));
	}
	
	protected void accelerateNorthEast()
	{
		controllingCar.move(new Point2D.Float(1, 1));	
	}
	
	protected void accelerateWest()
	{
		controllingCar.move(new Point2D.Float(-1, 0));
	}
	
	protected void accelerateEast()
	{
		controllingCar.move(new Point2D.Float(1, 0));
	}
	
	protected void accelerateSouthWest()
	{
		controllingCar.move(new Point2D.Float(-1, -1));
	}
	
	protected void accelerateSouth()
	{
		controllingCar.move(new Point2D.Float(0, -1));
	}
	
	protected void accelerateSouthEast()
	{
		controllingCar.move(new Point2D.Float(1, -1));
	}
	
	protected void moveToPrincipalPoint()
	{
		controllingCar.move(new Point2D.Float(0, 0));
	}
}
