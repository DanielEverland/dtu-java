import java.util.Random;

public class GameOfLife
{
	public GameOfLife(int n)
	{
		State = new int[n][n];		
		Random rand = new Random();
		
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < n; x++)
			{
				if(rand.nextFloat() < CELL_ALIVE_CHANCE)
					State[y][x] = CELL_ALIVE;
			}
		}
	}
	
	public GameOfLife(int[][] initialState)
	{
		State = initialState;
	}
	
	public int[][] State;
	
	private static float CELL_ALIVE_CHANCE = 0.3f;
	private static int CELL_ALIVE = 1;
	private static int CELL_DEAD = 0;
	
	public void nextState()
	{
		// Created in new array so old state is not overwritten as we iterate
		int[][] newState = new int[State.length][];
		
		for(int y = 0; y < State.length; y++)
		{
			newState[y] = new int[State[y].length];
			
			for (int x = 0; x < State[y].length; x++)
			{
				int aliveNeighbours = liveNeighbours(x, y);
				newState[y][x] = getNextCellState(State[y][x], aliveNeighbours);
			}
		}
		
		State = newState;
	}
	
	public boolean isAlive(int x, int y)
	{
		if(isValidIndex(x, y))
			return State[y][x] == CELL_ALIVE;
			
		return false;
	}
	
	private int liveNeighbours(int x, int y)
	{
		int aliveNeighbours = 0;
		
		for(int xOffset = -1; xOffset <= 1; xOffset++)
		{
			for(int yOffset = -1; yOffset <= 1; yOffset++)
			{
				if (xOffset == 0 && yOffset == 0)
					continue;
				
				int actualX = x + xOffset;
				int actualY = y + yOffset;
				
				if(!isValidIndex(actualX, actualY))
					continue;
				
				if(State[actualY][actualX] == CELL_ALIVE)
					aliveNeighbours++;
			}
		}
		
		return aliveNeighbours;
	}
	
	private int getNextCellState(int currentCellState, int aliveNeighbours)
	{
		if(currentCellState == CELL_ALIVE && (aliveNeighbours < 2 || aliveNeighbours > 3))
			return CELL_DEAD;
		else if(currentCellState != CELL_ALIVE && aliveNeighbours == 3)
			return CELL_ALIVE;
		
		return currentCellState;
	}
	
	private boolean isValidIndex(int x, int y)
	{
		return x >= 0 && y >= 0 && y < State.length && x < State[y].length; 
	}
}
