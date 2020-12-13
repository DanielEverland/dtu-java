import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class GameOfLifeMain
{
	public static void main(String[] args) {
		StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		StdDraw.enableDoubleBuffering();
		
		try
		{
			// Attempt to read from file. If that fails, defer to a randomly created GameOfLife
			readFromFile();
			return;
		}
		catch(Exception e)
		{
		}
		
		initialize(new GameOfLife(50));
	}
	
	// Change this in order to change the "speed" of the game.
	private static final int DRAW_INTERVAL = 500;
	private static final int CANVAS_WIDTH = 1000;
	private static final int CANVAS_HEIGHT = 1000;
	private static final Color COLOR_ALIVE = StdDraw.BLACK;
	
	private static GameOfLife currentGame;
	private static int xBounds;
	private static int yBounds;
	private static float circleRadius;
	
	private static void initialize(GameOfLife newGame) {
		currentGame = newGame;
		
		// These values are simply used in order to properly scale drawing to fit the viewport of the window
		calculateBounds();
		calculateRadius();
		
		show();
	}
	
	private static void show() {
		// Run the game forever
		while(true)
		{
			clearCanvas();
			
			StdDraw.setPenColor(COLOR_ALIVE);
			
			for(int y = 0; y < currentGame.State.length; y++)
			{
				for(int x = 0; x < currentGame.State[y].length; x++)
				{
					if(currentGame.isAlive(x, y))
						drawCell(x, y);
				}
			}
			
			// Used instead of the show method from assignment, since it's deprecated.
			StdDraw.show();
			StdDraw.pause(DRAW_INTERVAL);

			currentGame.nextState();
		}
	}
	
	private static void readFromFile() throws FileNotFoundException {
		System.out.println("Please input a full path for an input file, or simply press enter to play a random game");
		
		Scanner consoleInput = new Scanner(System.in);
		String inputFilePath = consoleInput.nextLine();
		consoleInput.close();
		
		File inputFile = new File(inputFilePath);
		Scanner inputFileScanner = new Scanner(inputFile);
		
		// We can't know for certain how big the GameOfLife read from a file is, so store it in this
		// pre-defined array, while we're reading.
		int[][] inputBuffer = new int[100][100];
		int width = 0, height = 0;
		
		while(inputFileScanner.hasNext())
		{
			int tempWidth = 0;
			String nextString = inputFileScanner.nextLine();
			for(int i = 0; i < nextString.length(); i++)
			{
				char nextChar = nextString.charAt(i);
				try
				{
					// If it's not an integer this will throw an exception. It's caught, so that's fine,
					// the program will simply move on.
					int number = Integer.parseInt(String.valueOf(nextChar));
					if(number == 1 || number == 0)
					{
						inputBuffer[height][tempWidth] = number;
						tempWidth++;
					}						
				}
				catch (Exception e)
				{
				}
			}
			
			width = tempWidth > width ? tempWidth : width;			
			height++;
			System.out.println();
		}
		
		// Create a new input array from buffer
		int[][] actualInput = new int[height][width];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				actualInput[y][x] = inputBuffer[y][x];
			}
		}
		
		inputFileScanner.close();
		
		initialize(new GameOfLife(actualInput));
	}
	
	private static void calculateBounds() {
		yBounds = currentGame.State.length;
		xBounds = 0;
		
		for(int y = 0; y < currentGame.State.length; y++)
		{
			int currentWidth = currentGame.State[y].length;
			if(currentWidth > xBounds)
				xBounds = currentWidth;
		}
	}
	
	private static void calculateRadius() {
		int smallestBounds = xBounds < yBounds ? xBounds : yBounds;
		
		circleRadius = (1.0f / smallestBounds) / 2;
	}
	
	private static void clearCanvas() {
		StdDraw.clear();
	}
	
	private static void drawCell(int x, int y) {
		float viewportX = (float)x / xBounds + circleRadius;
		
		// Drawing is inverted because the "start" of the array is supposed to be
		// at the top, but (0, 0) is bottom left 
		float viewportY = 1 - (float)y / yBounds - circleRadius;
		
		StdDraw.filledCircle(viewportX, viewportY, circleRadius);
	}
}
