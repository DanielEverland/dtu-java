import java.awt.geom.Point2D;

// Generalized class for physical objects in the world
public abstract class GameObject
{
	public GameObject(WorldBase world, GameMaster gameMaster)
	{
		this.World = world;
		this.GameMaster = gameMaster;
	}
	
	public Point2D.Float Position = new Point2D.Float();
	
	protected WorldBase World;
	protected GameMaster GameMaster;
}
