package main;

import java.util.Calendar;

import dao.*;
import transactions.Catalog;
import transactions.ListLoans;
import transactions.People;

public class Main {

	private static final ListLoans LIST_LOANS = ListLoans.getInstance();
	private static final People PEOPLE = People.getInstance();
	private static final Catalog CATALOG = Catalog.getInstance();
	private static int i;

	public static void main(String[] args) {

		CATALOG.loadMap();
		PEOPLE.loadMap();
		LIST_LOANS.loadMap();
		System.out.println(
				"You are the genius scientist Sheldon Cooper or an invited? (press enter if you are not Sheldon Cooper)");
		String username = In.readLine();
		if (!username.trim().equals("")) {
			System.out.println("Please enter your password");
			String pwd = In.readLine();

			if (UserDao.login(username, pwd)) {
				String menu = "\n1-Register a new friend\n2-Register a new genre\n3-Register a new Comic\n4-Friends List\n"
						+ "5-Register loan\n6-See all comics\n7-Delete comic\n8-Delete a no longer friend\n9-Update Comic"
						+ "\n10-Update loan\n11-Update person\n12-List all loans\n13-Exit";
				System.out.println("Hi Sheldon, please choose an option");
				System.out.println(menu);
				do {
					String name, description, genre, phone, adress = "";
					i = In.readInt();
					switch (i) {
					case 1:
						System.out.println("Enter the name:");
						name = In.readLine();
						System.out.println("Enter the phone number:");
						phone = In.readLine();
						System.out.println("Enter the adress");
						adress = In.readLine();
						PersonDao.insertPerson(name, phone, adress);
						PEOPLE.loadMap();
						break;
					case 2:
						System.out.println("Enter name:");
						name = In.readLine();
						System.out.println("Enter description:");
						description = In.readLine();
						ComicDao.insertGenre(name, description);
						break;
					case 3:
						System.out.println("Enter the name:");
						name = In.readLine();
						System.out.println("Enter the genre (Science Fiction or Superheroes):");
						genre = In.readLine();
						ComicDao.insertComic(name, genre);
						CATALOG.loadMap();
						break;
					case 4:
						System.out.println("Friends:\n");
						System.out.println(PEOPLE.showMap());
						break;
					case 5:
						System.out.println("Enter the name of your friend");
						name = In.readLine();
						System.out.println("Enter the name of the comic");
						String comicLoan = In.readLine();
						LoanDao.insertLoan(name, comicLoan, Calendar.getInstance());
						break;
					case 6:
						System.out.println("Comics:\n");
						System.out.println(CATALOG.showMap());
						break;
					case 7:
						System.out.println("Enter the name: ");
						name = In.readLine();
						ComicDao.deleteComic(name);
						break;
					case 8:
						System.out.println("Enter the name who the one that is no longer your friend:");
						name = In.readLine();
						PersonDao.deletePerson(name);
						break;
					case 9:
						System.out.println("Enter the name of the comic you want to update:");
						name = In.readLine();
						System.out.println("Enter the new name:");
						String nameNew = In.readLine();
						System.out.println("Enter the genre:");
						genre = In.readLine();
						System.out.println("Enter the number:");
						int number = In.readInt();
						ComicDao.updateComic(number, nameNew, genre, name);
						CATALOG.loadMap();
						break;
					case 10:
						System.out.println("Enter the name of your friend:");
						name = In.readLine();
						System.out.println("Name of the comic:");
						String nameComicLoan = In.readLine();
						LoanDao.updateLoan(name, nameComicLoan);
						LIST_LOANS.loadMap();
						break;
					case 11:
						System.out.println("Enter the name who wants to update the info:");
						name = In.readLine();
						System.out.println("Enter the new phone number:");
						phone = In.readLine();
						System.out.println("Enter the new adress");
						adress = In.readLine();
						PersonDao.updatePerson(name, phone, adress);
						break;
					case 12:
						System.out.println("List of all loan: ");
						System.out.println(LIST_LOANS.showMap());
						break;
					case 13:
						break;
					default:
						System.out.println("It's not a valid option");
						break;
					}

				} while (i != 13);

			} else {
				System.out.println("Password is wrong! You are not the great genius Sheldon, IMPOSTOR!");
			}
		} else {
			System.out.println("Hi friend! please check the comics i have");
			String menu = "\n1-Search for a comic\n2-Check all comics\n3-Exit";
			System.out.println(menu);
			do {
				i = In.readInt();
				switch (i) {
				case 1:
					System.out.println("Enter a comic name:");
					String name = In.readLine();
					System.out.println(ComicDao.searchComic(name).toString());
					break;
				case 2:
					System.out.println("Comics:\n");
					System.out.println(CATALOG.showMap());
					break;
				case 3:
					break;
				default:
					break;
				}

			} while (i != 3);
		}

	}

}
