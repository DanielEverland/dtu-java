import java.awt.Color;
import java.io.File;
import java.util.Scanner;

public class Mandelbrot
{
	private static final int MAX = 255;
	private static final int GRID_SIZE = 1000;
	private static final int VIEWPORT_SIZE = GRID_SIZE;
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static double x;
	private static double y;
	private static double s;
	private static float radius;
	private static int[][] colors = new int[3][256];
	
	public static void main(String[] args)
	{
		try
		{
			readColorFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		
		readConsole();
		setupViewport();
		drawImage();
	}
	
	private static void readColorFile() throws Exception
	{
		System.out.println("Please input the full path to a color file: ");
		String path = scanner.nextLine();
		
		try
		{
			File colorFile = new File(path);
			Scanner fileScanner = new Scanner(colorFile);
			int lineNumber = 0;
			while(fileScanner.hasNextLine())
			{
				String currentLine = fileScanner.nextLine();
				currentLine = currentLine.stripLeading();
				currentLine = currentLine.stripTrailing();
				
				// "\\s+" is a regex pattern that matches several whitespace character
				String[] stringNumbers = currentLine.split("\\s+");
				
				if(stringNumbers.length != 3)
				{
					System.out.println("Error while reading line " + (lineNumber + 1) + ". There were not 3 numbers in row");
					throw new Exception();
				}
				
				for(int i = 0; i < 3; i++)
				{
					int colorValue = Integer.parseInt(stringNumbers[i]);
					colors[i][lineNumber] = colorValue;
				}				
				
				lineNumber++;
			}
			
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println("Couldn't read file " + path);
			throw e;
		}
	}
	
	private static void drawImage()
	{
		for(int x = 0; x < GRID_SIZE; x++)
		{
			for(int y = 0; y < GRID_SIZE; y++)
			{
				Complex value = getValue(x, y);
				int iteration = iterate(value);
				drawPoint(x, y, iteration);
			}
		}
		
		StdDraw.show();
	}
	
	private static void drawPoint(int x, int y, int iterationValue)
	{
		setColor(iterationValue);
		
		float viewportX = (float)x / GRID_SIZE + radius;
		float viewportY = (float)y / GRID_SIZE + radius;
		
		StdDraw.filledSquare(viewportX, viewportY, radius);
	}
	
	private static void setColor(int iterationValue)
	{
		StdDraw.setPenColor(new Color(colors[0][iterationValue], colors[1][iterationValue], colors[2][iterationValue]));
	}
		
	private static void readConsole()
	{
		System.out.println("Please enter x: ");
		x = readNumber();
		
		System.out.println("Please enter y: ");
		y = readNumber();
		
		System.out.println("Please enter s: ");
		s = readNumber();
	}
	
	private static double readNumber()
	{
		while(true)
		{
			try
			{
				double value = Double.parseDouble(scanner.nextLine());
				return value;
			}
			catch(Exception e)
			{
				System.out.println("Couldn't read input (" + e.getMessage() + "), please enter make sure you only enter a number");
			}
		}
	}
	
	private static void setupViewport()
	{
		StdDraw.setCanvasSize(VIEWPORT_SIZE, VIEWPORT_SIZE);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(Color.RED);
		
		radius = (1 / (float)GRID_SIZE) / 2;
	}
	
	private static int iterate(Complex z0)
	{
		Complex z = new Complex(z0);
		for(int i = 0; i < MAX; i++)
		{
			if(z.abs() > 2.0)
				return i;
			
			z = z.times(z).plus(z0);
		}
		
		return MAX;
	}
	
	private static Complex getValue(int row, int column)
	{
		double real = x - s / 2 + ((s * row) / (GRID_SIZE - 1));
		double imaginary = y - s / 2 + ((s * column) / (GRID_SIZE - 1));
		
		return new Complex(real, imaginary);
	}
}
