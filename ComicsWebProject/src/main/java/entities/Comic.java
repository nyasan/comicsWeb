package entities;

public class Comic {

	private String name;
	private Genre type;

	public Comic() {
	}

	public Comic(String name, Genre type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getType() {
		return type;
	}

	public void setType(Genre type) {
		this.type = type;
	}

}
