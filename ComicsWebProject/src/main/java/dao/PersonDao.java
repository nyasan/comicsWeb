package dao;

import java.util.HashMap;

import entities.Comic;
import entities.Copy;
import entities.Person;
import transactions.People;

public class PersonDao {

	public static void insertPerson(String name, String phone, String adress) {
		Command.insert("INSERT INTO People (name,telephone,adress) VALUES (?,?,?)", new Person(name, phone, adress));
	}

	public static HashMap<String, Object> selectPeople() {
		return Command.select("SELECT * FROM people", new Person());
	}

	public static void deletePerson(String name) {
		Command.delete("DELETE FROM people WHERE name LIKE ?", name);
	}

	public static void updatePerson(String name, String telephone, String adress) {
		Command.update("UPDATE People SET telephone=?,adress=? WHERE name LIKE ?", new Person(name, telephone, adress),
				name);
	}
	
	public static Object searchPerson(String name) {
		return Command.search("SELECT * FROM People WHERE name LIKE ?", new Person(name, "", ""),
				null);
	}
}
