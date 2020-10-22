import java.awt.geom.Point2D;
import java.awt.Color;

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
	
	private void notifyWorldOfPosition()
	{
		World.addCarLocation(this);
	}
}
