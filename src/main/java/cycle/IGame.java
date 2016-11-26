package cycle;

import java.util.ArrayList;
import entities.Entity;

public interface IGame {
	public void initialise();
	public void performDay();
	public void performNight();
	public void setEntityList(ArrayList<Entity> list);
	
	public void addEntity(Entity e);
	public void removeEntity(Entity e);
}
