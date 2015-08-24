package entities;

import java.util.Calendar;

import entities.*;

public class Loan {

	private Calendar date;
	private Person person;
	private Copy comic;

	public Loan() {

	}

	public Loan(Person person, Copy comic) {
		super();
		this.date = Calendar.getInstance();
		this.person = person;
		this.comic = comic;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Copy getComic() {
		return comic;
	}

	public void setComic(Copy comic) {
		this.comic = comic;
	}

	@Override
	public String toString() {
		return "Date:" + date.getTime() + ", Person:" + person.getName() + ", Comic:" + comic.getC().getName() + "He/she dont have returned it yet";
	}

}
