package dao;

import java.util.Calendar;
import java.util.HashMap;

import entities.Comic;
import entities.Copy;
import entities.Loan;
import entities.Person;

public class LoanDao {

	public static void insertLoan(String peopleName, String comicName, Calendar date) {
		Command.insert("INSERT INTO loans (id_people,id_comic,date) VALUES (?,?,?)",
				new Loan(new Person(peopleName, "", ""), new Copy(0, new Comic(comicName, null), false)));
	}

	public static void updateLoan(String... name) {
		Command.update("UPDATE loans SET date_return=? WHERE id_people=? AND id_comic=?", new Loan(), name);
	}
	
	public static HashMap<String, Object> selectLoans(){
		return Command.select("SELECT * FROM loans WHERE date_return is null", new Loan());
	}
}
