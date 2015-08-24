package entities;

public class Person {

	private String name;
	private String telephone;
	private String adress;

	public Person() {

	}

	public Person(String name, String phone, String adress) {
		this.name = name;
		this.telephone = phone;
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Name: "+name+", Telephone:" + telephone + ", adress:" + adress;
	}

}
