import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D.Float;
import java.util.Random;

public class SquareWorld extends WorldBase
{
	private final static int MAX_BOUNDS_WIDTH = 15;
	private final static int MIN_BOUNDS_WIDTH = 5;
	private final static int MAX_DISTANCE_TO_CENTER_SQUARE = 8;
	private final static int MIN_DISTANCE_TO_CENTER_SQUARE = 3;
	
	private Random rand;
	
	// Used for iterating over the entire world's points.
	private Point2D.Float currentIteratorPoint;
	
	// The center square is the obstacle in the middle of the world that cars cannot enter.
	private Rectangle centerSquare;
	
	// The bounds of the world define the perimeter of the world
	private Point2D.Float bounds;
	
	public SquareWorld()
	{
		rand = new Random();
		resetIterator();

		createBounds();
		createCenterSquare();
	}
	
	public void beginIterating()
	{
		resetIterator();
	}
	
	public Point2D.Float getNext()
	{
		// This means the iterator has been reset, and it has to be set to its initial point (0, 0)
		if(currentIteratorPoint == null)
		{
			currentIteratorPoint = new Point2D.Float(0, 0);
			return currentIteratorPoint; 
		}
		
		float currentX = (float)currentIteratorPoint.getX();
		float currentY = (float)currentIteratorPoint.getY();
		
		// Try moving to the right
		currentIteratorPoint = new Point2D.Float(currentX + 1, currentY);
		
		// If we're within the center square when moving to right, we need to move all the way to the right of the entire center square
		if(centerSquare.contains(currentIteratorPoint))
		{
			currentIteratorPoint = new Point2D.Float(centerSquare.x + centerSquare.width + 1, currentY);
			return currentIteratorPoint;
		}		
		
		// A simple move to the right is valid
		if(exists(currentIteratorPoint))
			return currentIteratorPoint;
		
		// Try moving down one row
		currentIteratorPoint = new Point2D.Float(0, currentY + 1);
		if(exists(currentIteratorPoint))
			return currentIteratorPoint;
		
		// There are no other possible options, we must have iterated over the entire world at this point.
		currentIteratorPoint = null;
		return currentIteratorPoint;
	}
	
	public FinishLineCrossType crossedFinishLine(Car movingCar, Point2D.Float startingPoint, Point2D.Float endPoint)
	{
		Line2D.Float move = new Line2D.Float(startingPoint, endPoint);
		Line2D.Float finishLine = getFinishLine();
		
		if(move.intersectsLine(finishLine))
		{
			int xDirection = (int)(endPoint.x - startingPoint.x);
			if(xDirection > 0 && finishLine.ptLineDist(endPoint) < 1 && finishLine.ptLineDist(endPoint) < 1)
			{
				return FinishLineCrossType.RightWay;
			}
			else if (xDirection < 0)
			{
				return FinishLineCrossType.WrongWay;
			}
		}
		
		return FinishLineCrossType.None;		
	}
	
	public boolean isValidMove(Car movingCar, Point2D.Float startingPoint, Point2D.Float endPoint)
	{
		Line2D.Float move = new Line2D.Float(startingPoint, endPoint);		
		return exists(endPoint) && !hitsAnyCar(movingCar, startingPoint, endPoint) && !centerSquare.intersectsLine(move); 
	}
	
	private boolean hitsAnyCar(Car movingCar, Point2D.Float startingPoint, Point2D.Float endPoint)
	{
		for(Car car : AllCars)
		{
			if(car == movingCar)
				continue;
			
			if((int)car.Position.x == (int)endPoint.x && (int)car.Position.y == (int)endPoint.y)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public Line2D.Float getFinishLine()
	{
		float xPos = (int)(bounds.getX() / 2);
		return new Line2D.Float(xPos, centerSquare.y + centerSquare.height, xPos, (float)bounds.getY());
	}
	
	public boolean exists(Point2D.Float point)
	{
		//Rectangle test = new Rectangle(centerSquare.x + 1, centerSquare.y, centerSquare.width + 1, centerSquare.height);
		// If the point is within the center square, it's out of bounds
		if(centerSquare.contains(point))
			return false;
		
		// Since we've already concluded it's not in the center square,
		// it is definitely within the world as long as it's not outside of the world bounds.
		return isWithinWorldBounds(point);
	}
	
	// Returns whether the given point is within the maximum bounds of the world
	private boolean isWithinWorldBounds(Point2D.Float point)
	{
		return point.getX() >= 0 && point.getX() <= bounds.getX() && point.getY() >= 0 && point.getY() <= bounds.getY();
	}
	
	private void createBounds()
	{
		int boundsSize = MIN_BOUNDS_WIDTH + rand.nextInt(MAX_BOUNDS_WIDTH - MIN_BOUNDS_WIDTH);
		boundsSize = 16;
		
		if(boundsSize % 2 == 0)
			boundsSize++;
		
		bounds = new Point2D.Float(boundsSize, boundsSize);
	}
	
	private void createCenterSquare()
	{
		int distanceToCenter = MIN_DISTANCE_TO_CENTER_SQUARE + rand.nextInt(MAX_DISTANCE_TO_CENTER_SQUARE - MIN_DISTANCE_TO_CENTER_SQUARE);
		int size = (int)bounds.getX() - distanceToCenter * 2;
		if(size % 2 == 0)
			size++;
		
		centerSquare = new Rectangle(distanceToCenter, distanceToCenter, size, size);
	}
	
	private void resetIterator()
	{
		currentIteratorPoint = null;
	}
	
	
}