package cycle;

public interface IGame {
	public void initialise();
	public void performDay();
	public void performNight();
	public void setEntityList(ArrayList<Entity> list);
}
