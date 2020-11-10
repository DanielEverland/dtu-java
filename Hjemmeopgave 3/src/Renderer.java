import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;

// Draws objects in the window
public class Renderer
{
	private static final int CELL_SIZE = 16;
	private static final Color COLOR_CELL_BACKGROUND = StdDraw.GRAY;
	private static final Color COLOR_CELL_OUTLINE = StdDraw.BLACK;
	private static final Color FINISHLINE_COLOR = StdDraw.GREEN;
	private static final float LINE_RADIUS = 0.01f;
	private static final Color COLOR_CAR = StdDraw.BLACK;
	private static final float CAR_RADIUS = 0.6f;
	
	private static int viewportSize;
	
	// Draws the entire world to the canvas.
	public static void drawWorld(WorldBase world)
	{
		world.beginIterating();
		Point2D.Float currentPoint = world.getNext();
		
		int worldBoundsX = (int)world.getBounds().x;
		int worldBoundsY = (int)world.getBounds().y;
		viewportSize = (worldBoundsX > worldBoundsY ? worldBoundsX : worldBoundsY) * CELL_SIZE;
		
		StdDraw.setCanvasSize(viewportSize, viewportSize);
		StdDraw.enableDoubleBuffering();
		
		while(currentPoint != null)
		{
			drawCell(currentPoint);
			currentPoint = world.getNext();
		}
		
		drawFinishLine(world.getFinishLine());
		
		StdDraw.show();
	}
	
	// Called after every turn has ended to draw new frame
	public static void render(WorldBase world)
	{
		drawPaths(world);
		drawCars(world);
		
		StdDraw.show();
	}
	
	private static void drawCars(WorldBase world)
	{
		StdDraw.setPenColor(COLOR_CAR);
		
		for(Map.Entry<Car, ArrayList<Point2D.Float>> entry : world.CarLocations.entrySet())
		{
			for(int i = 0; i < entry.getValue().size(); i++)
			{
				StdDraw.filledCircle(coordinateToViewport(entry.getValue().get(i).x), coordinateToViewport(entry.getValue().get(i).y), CAR_RADIUS * getViewportCellHalfSize());
			}			
		}
	}
	
	private static void drawPaths(WorldBase world)
	{
		for(Map.Entry<Car, ArrayList<Point2D.Float>> entry : world.CarLocations.entrySet())
		{
			StdDraw.setPenColor(entry.getKey().CarColor);
			
			for(int i = 0; i < entry.getValue().size() - 1; i++)
			{
				Point2D.Float startPos = entry.getValue().get(i);
				Point2D.Float endPos = entry.getValue().get(i + 1);
				
				StdDraw.line(coordinateToViewport(startPos.x), coordinateToViewport(startPos.y),
						coordinateToViewport(endPos.x), coordinateToViewport(endPos.y));
			}			
		}
	}
	
	private static void drawCell(Point2D.Float point)
	{
		Point2D.Float viewportPos = pointToViewport(point);
		
		StdDraw.setPenColor(COLOR_CELL_BACKGROUND);
		StdDraw.filledSquare(viewportPos.getX() + getViewportCellHalfSize(), viewportPos.getY() + getViewportCellHalfSize(), getViewportCellHalfSize());
		
		StdDraw.setPenColor(COLOR_CELL_OUTLINE);
		StdDraw.square(viewportPos.getX() + getViewportCellHalfSize(), viewportPos.getY() + getViewportCellHalfSize(), getViewportCellHalfSize());
	}
	
	private static void drawFinishLine(Line2D.Float finishLine)
	{
		StdDraw.setPenColor(FINISHLINE_COLOR);
		StdDraw.setPenRadius(LINE_RADIUS);
		
		StdDraw.line(coordinateToViewport(finishLine.getX1()), coordinateToViewport(finishLine.getY1()),
				coordinateToViewport(finishLine.getX2()), coordinateToViewport(finishLine.getY2() + 1));
	}
	
	// Converts the point to cell space and then to viewport space (0 - 1)
	private static Point2D.Float pointToViewport(Point2D.Float point)
	{
		return new Point2D.Float(coordinateToViewport(point.getX()), coordinateToViewport(point.getY()));
	}
	
	private static float getViewportCellHalfSize()
	{
		return (float)CELL_SIZE / viewportSize / 2.f;		
	}
	
	// Converts a singular coordinate to viewport space
	private static float coordinateToViewport(double coordinate)
	{
		return (float)coordinate * CELL_SIZE / viewportSize;
	}
}
