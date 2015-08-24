package main;
/**This class manage the Input events in the application.
 * It had been done for Academic purpose in Universidad Tecnlogica Nacional - Facultad Regional Córdoba - Argentina
 * last Update by @ValerioFritelli in 2004  
 * **/
public class In {

	public static char readChar() {
		char ch = ' ';
		try {
			ch = (char) System.in.read();
			System.in.read();
		} catch (java.io.IOException e) {
		}
		return ch;
	}

	public static String readLine() {
		int ch;
		String r = "";
		boolean done = false;
		while (!done) {
			try {
				ch = System.in.read();
				if (ch < 0 || (char) ch == '\n') {
					done = true;
				} else {
					if ((char) ch != '\r') {
						r = r + (char) ch;
					}
				}
			} catch (java.io.IOException e) {
				done = true;
			}
		}
		return r;
	}

	public static int readInt() {
		while (true) {
			try {
				return Integer.parseInt(readLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("It's not an Integer please try again");
			}
		}
	}

	public static double readDouble() {
		while (true) {
			try {
				return Double.parseDouble(readLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("it's not a float, please try again");
			}
		}
	}
}
