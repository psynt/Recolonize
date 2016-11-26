package application;

public class OneName implements NameGen {
	private String name;
	
	public OneName(String n) {
		name=n;
	}

	@Override
	public String giveName() {
		return name;
	}

}
