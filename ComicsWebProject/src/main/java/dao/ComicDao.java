package dao;

import java.util.HashMap;

import entities.Comic;
import entities.Copy;
import entities.Genre;
import transactions.Catalog;

public class ComicDao {

	public static void insertGenre(String name, String description) {
		Command.insert("INSERT INTO genres (name,description) VALUES (?,?)", new Genre(name, description));
	}

	public static void insertComic(String name, String genre) {
		Command.insert("INSERT INTO comics(id_genre,avalible,name,number) VALUES (?,?,?,?)",
				new Copy(1, new Comic(name, new Genre(genre, "")), true));
	}

	public static HashMap<String, Object> selectComics() {
		return Command.select("SELECT * FROM comics", new Copy());
	}
	
	public static HashMap<String, Object> selectGenres() {
		return Command.select("SELECT * FROM genres", new Genre());
	}

	public static void updateComic(int number, String name, String genre, String nameOriginal) {
		Command.update("UPDATE comics SET id_genre=?,name=?,number=? WHERE name=?",
				new Copy(number, new Comic(name, new Genre(genre, "")), true), nameOriginal);
	}

	public static void deleteComic(String name) {
		Command.delete("DELETE FROM comics WHERE name LIKE ?", name);
	}

	public static Object searchComic(String name) {
		return Command.search("SELECT * FROM Comics WHERE name LIKE ?", new Copy(0, new Comic(name, null), false),
				null);
	}
}
