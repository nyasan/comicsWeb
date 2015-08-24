package transactions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dao.ConnectionManager;
import dao.PersonDao;
/** This class manage the Persons object. It keeps a HashMap in memory for easy access. 
 * 	It's implement the Iterator and Singleton patron.
 * **/
public class People {

	private static Iterator it;
	private HashMap<String, Object> map;
	private static volatile People instance;

	public static People getInstance() {
		if (instance == null) {
			synchronized (ConnectionManager.class) {
				if (instance == null) {
					instance = new People();
				}
			}
		}

		return instance;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public String showMap() {
		StringBuffer sb = new StringBuffer();
		it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			sb.append(e.getKey() + " " + e.getValue() + "\n");
		}
		return sb.toString();
	}

	public void loadMap() {
		map = PersonDao.selectPeople();
	}
}
