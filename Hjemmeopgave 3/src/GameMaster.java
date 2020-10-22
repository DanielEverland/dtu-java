import java.util.ArrayList;

// Responsible for deciding what happens during the game
public abstract class GameMaster
{
	public Controller Winner = null;
	
	protected WorldBase World;
	
	private boolean gameIsOver = false;
	private ArrayList<Controller> controllers;
	private Controller currentlyActiveController;
	
	GameMaster(WorldBase world)
	{
		this.World = world;
		this.controllers = new ArrayList<Controller>();
	}
	
	// A car has crossed the finish line the wrong way
	public void carCrossedFinishLineWrongWay()
	{
		System.out.println(currentlyActiveController.Name + " crossed the finish line the wrong way, and was disqualified!");
		currentlyActiveController.disable();
	}
	
	// A car has crossed the finish line the correct way
	public void carCrossedFinishLine()
	{
		System.out.println(currentlyActiveController.Name + " crossed the finish line!");
		setWinner(currentlyActiveController);
	}
	
	public void carCrashed()
	{
		System.out.println(currentlyActiveController.Name + " crashed!");
		currentlyActiveController.disable();
	}
	
	// Called when a controller has finished its turn
	public void controllerTurnEnded(Controller endedController)
	{
		if(endedController != currentlyActiveController)
			throw new IllegalArgumentException();
		
		Renderer.render(World);
		
		if(!gameIsOver)
		{
			Controller controller = getNextController(currentlyActiveController);
			
			// Controller is null if there are no more valid controllers, and the game has ended
			if(controller != null)
				startTurn(getNextController(currentlyActiveController));
		}
			
	}
	
	protected void beginGame()
	{
		Renderer.render(World);
		startTurn(controllers.get(0));		
	}
	
	protected void registerController(Controller controller)
	{
		if(!controllers.contains(controller))
			controllers.add(controller);
	}
		
	private void printTurnsTaken()
	{
		for(Controller controller : controllers)
		{
			System.out.println(controller.Name + " has taken " + controller.getTurnsTaken() + " turns.");
		}
	}
	
	private void setWinner(Controller controller)
	{
		printTurnsTaken();
		
		Winner = controller;
		gameIsOver = true;
		System.out.println("The winner is " + controller.Name + "!");
	}
	
	private void startTurn(Controller controller)
	{
		currentlyActiveController = controller;
		currentlyActiveController.beginTurn();
	}
	
	private void gameLost(Controller controller)
	{
		System.out.println("No cars have finished! The game is lost.");
		
		printTurnsTaken();
		gameIsOver = true;		
	}
	
	// Returns the controller which is next in the list of all controllers
	private Controller getNextController(Controller entry)
	{
		int startIndex = controllers.indexOf(entry);
		int index = startIndex + 1;
		while(index != startIndex)
		{
			if(index >= controllers.size() - 1)
				index = 0;
			
			Controller currentController = controllers.get(index); 
			if(currentController.getIsActive())
				return currentController;
		}
		
		gameLost(entry);
		return null;
	}
}
