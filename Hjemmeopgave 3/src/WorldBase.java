import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public abstract class WorldBase
{
	public ArrayList<Car> AllCars = new ArrayList<Car>();
	public Hashtable<Car, ArrayList<Point2D.Float>> CarLocations = new Hashtable<Car, ArrayList<Point2D.Float>>(); 
	
	private ArrayList<Point2D.Float> usedStartingLocations = new ArrayList<Point2D.Float>();
	
	// Gets the bounds of the world
	public abstract Point2D.Float getBounds();
	
	// Resets the iterator in order to prepare for iteration over the entire world.
	public abstract void beginIterating();
	
	// Gets the next point in the world, if any. Null if iteration has completed.
	public abstract Point2D.Float getNext();
	
	// Gets the finish line for this world (also used for starting). P1 must be lowest point and P2 must be highest point.
	public abstract Line2D.Float getFinishLine();
	
	// Returns whether the given point exists in this world.
	public abstract boolean exists(Point2D.Float point);
	
	// Checks whether a given mode crossed the finish line
	public abstract FinishLineCrossType crossedFinishLine(Car movingCar, Point2D.Float startingPoint, Point2D.Float endPoint);
	
	// Checks whether a given move is valid
	public abstract boolean isValidMove(Car movingCar, Point2D.Float startingPoint, Point2D.Float endPoint);
	
	// Adds a car location to all locations visited during the session
	public void addCarLocation(Car car)
	{
		if(!CarLocations.containsKey(car))
		{
			CarLocations.put(car, new ArrayList<Point2D.Float>());
		}
		
		CarLocations.get(car).add(car.Position);
	}
	
	// Returns an unoccupied starting location
	public Point2D.Float getUnusedStartingLocation()
	{
		Line2D.Float finishLine = getFinishLine();
		ArrayList<Point2D.Float> allPossiblePositions = new ArrayList<Point2D.Float>();
		
		Point2D.Float currentLinePosition = new Point2D.Float((float)finishLine.getP1().getX(), (float)finishLine.getP1().getY() + 1);
		Point2D.Float endPosition = new Point2D.Float((float)finishLine.getP2().getX(), (float)finishLine.getP2().getY() - 1);
		
		allPossiblePositions.add(currentLinePosition);
		while(currentLinePosition.x != endPosition.x || currentLinePosition.y != endPosition.y)
		{
			currentLinePosition = new Point2D.Float(currentLinePosition.x, currentLinePosition.y + 1);
			allPossiblePositions.add(currentLinePosition);
		}
		
		Random rand = new Random();
		Point2D.Float chosenPoint;
		do
		{
			int randomIndex = rand.nextInt(allPossiblePositions.size() - 1);
			chosenPoint = allPossiblePositions.get(randomIndex);
			allPossiblePositions.remove(randomIndex);
		}
		while(hasUsedStartingPosition(chosenPoint));
		
		usedStartingLocations.add(chosenPoint);
		return chosenPoint;
	}
	
	// Registers a car with the world
	public void registerCar(Car car)
	{
		if(!AllCars.contains(car))
			AllCars.add(car);
	}
	
	private boolean hasUsedStartingPosition(Point2D.Float point)
	{
		for(int i = 0; i < usedStartingLocations.size(); i++)
		{
			Point2D.Float current = usedStartingLocations.get(i);
			if(current.x == point.x && current.y == point.y)
				return true;
		}
		
		return false;
	}
}
