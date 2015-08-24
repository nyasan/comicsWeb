package entities;

public class Copy {

	private int number;
	private Comic c;
	private boolean isAvalible;

	public Copy() {

	}

	public Copy(int number, Comic c, boolean isAvalible) {
		this.number = number;
		this.c = c;
		this.isAvalible = isAvalible;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Comic getC() {
		return c;
	}

	public void setC(Comic c) {
		this.c = c;
	}

	public boolean isAvalible() {
		return isAvalible;
	}

	public void setAvalible(boolean isAvalible) {
		this.isAvalible = isAvalible;
	}

	@Override
	public String toString() {
		return "Name: "+c.getName()+", Number:" + number + ", Genre:" + c.getType().getName() + ", Is Avalible?:" + isAvalible;
	}

}
