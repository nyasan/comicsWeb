package dao;

import authentication.User;

public class UserDao {

	public static boolean login(String username, String pwd) {
		return Command.login("SELECT * FROM Users WHERE username like ? AND password LIKE ?", new User(username, pwd));
	}
}
