package dao;
/**This class manage all the SQL operands as select,update or delete. Also has some methods like 
 * search and login that allows the user to look for a specific object.
 * **/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;

import authentication.User;
import entities.*;
import main.Tools;

public class Command {

	private static final ConnectionManager CONNECTION_MANAGER = ConnectionManager.getInstance();

	// This methods insert,update and delete the object for persistence purpose,
	// its check the instance in the parameter and then excecute
	// the corresponding commands.
	public static void insert(String sql, Object o) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = CONNECTION_MANAGER.open().prepareStatement(sql);
			if (o instanceof Person) {
				ps.setString(1, ((Person) o).getName());
				ps.setString(2, ((Person) o).getTelephone());
				ps.setString(3, ((Person) o).getAdress());
				i = ps.executeUpdate();
			}
			if (o instanceof Genre) {
				ps.setString(1, ((Genre) o).getName());
				ps.setString(2, ((Genre) o).getDescription());
				i = ps.executeUpdate();
			}
			if (o instanceof Copy) {
				int a = 0;
				int f = 0;
				f = selectId("SELECT id FROM Genres WHERE name LIKE ?", ((Copy) o).getC().getType().getName());
				if (((Copy) o).isAvalible() == true)
					a = 1;
				ps.setInt(1, f);
				ps.setInt(2, a);
				ps.setString(3, ((Copy) o).getC().getName());
				ps.setInt(4, ((Copy) o).getNumber());
				i = ps.executeUpdate();
			}
			if (o instanceof Loan) {
				int f = 0;
				int a = 0;
				a = selectId("SELECT id FROM Comics WHERE name LIKE ? AND avalible=1",
						((Loan) o).getComic().getC().getName());
				f = selectId("SELECT id FROM People WHERE name LIKE ?", ((Loan) o).getPerson().getName());
				ps.setInt(1, f);
				ps.setInt(2, a);
				ps.setDate(3, Tools.convertDateToSql(((Loan) o).getDate().getTime()));
				i = ps.executeUpdate();

				ps.clearBatch();

				ps = CONNECTION_MANAGER.open().prepareStatement("UPDATE Comics SET avalible=0 WHERE id=?");
				ps.setInt(1, a);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("There is an error with your submit, please check");
		} finally {
			if (i == 0) {
				System.out.println("The insert operand has failed");
			} else {
				System.out.println("The insert operand is successful!!");
			}
			CONNECTION_MANAGER.close();
		}
	}

	public static void update(String sql, Object o, String... name) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = CONNECTION_MANAGER.open().prepareStatement(sql);
			if (o instanceof Person) {
				ps.setString(1, ((Person) o).getTelephone());
				ps.setString(2, ((Person) o).getAdress());
				ps.setString(3, name[0]);
				i = ps.executeUpdate();
			}
			if (o instanceof Copy) {

				int f = 0;
				f = selectId("SELECT id FROM Genres WHERE name LIKE ?", ((Copy) o).getC().getType().getName());

				ps.setInt(1, f);
				ps.setString(2, ((Copy) o).getC().getName());
				ps.setInt(3, ((Copy) o).getNumber());
				ps.setString(4, name[0]);
				i = ps.executeUpdate();
			}
			if (o instanceof Loan) {
				int f = 0;
				int a = 0;
				ps.setDate(1, Tools.convertDateToSql(Calendar.getInstance().getTime()));
				f = selectId("SELECT id FROM People WHERE name LIKE ?", name[0]);
				a = selectId("SELECT id FROM Comics WHERE name LIKE ? AND avalible=0", name[1]);
				ps.setInt(2, f);
				ps.setInt(3, a);

				i = ps.executeUpdate();

				ps.clearBatch();

				ps = CONNECTION_MANAGER.open().prepareStatement("UPDATE Comics SET avalible=0 WHERE id=?");
				ps.setInt(1, a);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("There is an error with your submit, please check");
		} finally {
			if (i == 0) {
				System.out.println("The update operand has failed");
			} else {
				System.out.println("The update operand is successful!!");
			}
			CONNECTION_MANAGER.close();
		}
	}

	public static void delete(String sql, String name) {
		int i = 0;
		PreparedStatement ps;
		try {
			ps = CONNECTION_MANAGER.open().prepareStatement(sql);
			ps.setString(1, name);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("There is an error with your submit, please check");
		} finally {
			if (i == 0) {
				System.out.println("The delete operand has failed");
			} else {
				System.out.println("The delete operand is successful!!");
			}
			CONNECTION_MANAGER.close();
		}
	}

	// This method look for a specific object and retrieve his information.
	public static Object search(String sql, Object o, int... i) {
		PreparedStatement ps;
		try {
			ps = CONNECTION_MANAGER.open().prepareStatement(sql);
			if (o instanceof Person) {
				ps.setInt(1, i[0]);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					((Person) o).setName(rs.getString("name"));
					((Person) o).setAdress(rs.getString("adress"));
					((Person) o).setTelephone(rs.getString("telephone"));
				}
			}
			if (o instanceof Genre) {
				ps.setInt(1, i[0]);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					((Genre) o).setName(rs.getString("name"));
					((Genre) o).setDescription(rs.getString("description"));
				}
			}
			if (o instanceof Copy && i != null) {
				ps.setInt(1, i[0]);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					((Copy) o).setAvalible(rs.getInt("avalible") == 0 ? false : true);
					((Copy) o).setNumber(rs.getInt("number"));
					((Copy) o).setC(new Comic(rs.getString("name"),
							(Genre) search("SELECT * FROM genres WHERE id=?", new Genre(), rs.getInt("id_genre"))));
				}

			}
			if (o instanceof Copy && i == null) {
				ps.setString(1, ((Copy) o).getC().getName());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					((Copy) o).setAvalible(rs.getInt("avalible") == 0 ? false : true);
					((Copy) o).setNumber(rs.getInt("number"));
					((Copy) o).setC(new Comic(rs.getString("name"),
							(Genre) search("SELECT * FROM genres WHERE id=?", new Genre(), rs.getInt("id_genre"))));
				}

			}

		} catch (SQLException e) {
			System.out.println("Select command has fail!");
			System.out.println("There is an error with your submit, please check");
		} finally {
			CONNECTION_MANAGER.close();
		}
		return o;
	}

	public static HashMap<String, Object> select(String sql, Object o) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PreparedStatement ps;
		try {
			ps = CONNECTION_MANAGER.open().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (o instanceof Copy) {
				while (rs.next()) {
					o = new Copy();
					((Copy) o).setAvalible(rs.getInt("avalible") == 0 ? false : true);
					((Copy) o).setNumber(rs.getInt("number"));
					((Copy) o).setC(new Comic(rs.getString("name"),
							(Genre) search("SELECT * FROM genres WHERE id=?", new Genre(), rs.getInt("id_genre"))));
					map.put(((Copy) o).getC().getName(), o);
				}
			}
			if (o instanceof Person) {
				while (rs.next()) {
					o = new Person();
					((Person) o).setName(rs.getString("name"));
					((Person) o).setAdress(rs.getString("adress"));
					((Person) o).setTelephone(rs.getString("telephone"));
					map.put(((Person) o).getName(), o);
				}
			}
			if (o instanceof Loan) {
				while (rs.next()) {
					((Loan) o).setDate(Tools.DateToCalendar(rs.getDate("date")));
					((Loan) o).setPerson(
							(Person) search("SELECT * FROM people WHERE id=?", new Person(), rs.getInt("id_people")));
					((Loan) o).setComic(
							(Copy) search("SELECT * FROM Comics WHERE id=?", new Copy(), rs.getInt("id_comic")));
					map.put(((Loan) o).getPerson().getName(), o);
				}
			}
		} catch (SQLException e) {
			System.out.println("Select command has fail!");
			System.out.println("There is an error with your submit, please check");
		}

		return map;
	}

	public static int selectId(String sql, String a) {
		int id = 0;
		PreparedStatement ps;
		try {
			ps = CONNECTION_MANAGER.open().prepareStatement(sql);
			ps.setString(1, a);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There is an error with your submit, please check");
		}
		return id;
	}

	public static boolean login(String sql, Object o) {
		boolean a = false;
		PreparedStatement ps;
		if (o instanceof User) {
			try {
				ps = CONNECTION_MANAGER.open().prepareStatement(sql);
				ps.setString(1, ((User) o).getUsername());
				ps.setString(2, ((User) o).getPwd());
				ResultSet rs = ps.executeQuery();
				a = rs.next();
			} catch (SQLException e) {
				System.out.println("There is an error with your submit, please check");
			}
		}
		return a;
	}

}
