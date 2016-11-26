package cycle;

import java.util.ArrayList;
import entities.Entity;

public interface IGame {
	public void setEntityList(ArrayList<Entity> list);
	
	public void addEntity(Entity e);
	public void removeEntity(Entity e);
}
