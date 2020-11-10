import java.awt.geom.Point2D;
import java.awt.Color;

// Responsible for moving the car around in the world
public class Car extends GameObject
{
	public Color CarColor;
	
	private Point2D.Float velocity = new Point2D.Float();
	
	public Car(Point2D.Float startPosition, Color color, WorldBase world, GameMaster gameMaster)
	{
		super(world, gameMaster);
		
		Position = startPosition;
		CarColor = color;
		
		notifyWorldOfPosition();
	}
	
	// Moves the car and checks whether it crashed or crossed the finish line.
	public void move(Point2D.Float direction)
	{
		Point2D.Float oldPosition = Position;
		
		velocity = new Point2D.Float(velocity.x + direction.x, velocity.y + direction.y);
		Position = new Point2D.Float(Position.x + velocity.x, Position.y + velocity.y);
		
		if(!World.isValidMove(this, oldPosition, Position))
			GameMaster.carCrashed();
		
		FinishLineCrossType crossType = World.crossedFinishLine(this, oldPosition, Position); 
		if(crossType == FinishLineCrossType.RightWay)
		{
			GameMaster.carCrossedFinishLine();
		}
		else if(crossType == FinishLineCrossType.WrongWay)
		{
			GameMaster.carCrossedFinishLineWrongWay();
		}
		
		notifyWorldOfPosition();
	}
	
	// Tells the world object that the car has moved to a new position
	private void notifyWorldOfPosition()
	{
		World.addCarLocation(this);
	}
}
