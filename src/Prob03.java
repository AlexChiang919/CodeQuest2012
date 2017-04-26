import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Prob03 {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader(Prob03.class.getName() + ".in.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		while (scan.ready()) {
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(scan.readLine());
			boolean invalid = false;
			while (st.hasMoreTokens()) {
				try {
					list.add(Integer.parseInt(st.nextToken()));
				} catch (NumberFormatException ex) {
					invalid = true;
					printLine("The input was invalid");
					break;
				}
			}
			if (invalid)
				continue;
			if (ascending(list))
				printLine("The numbers are in ascending order");
			else if (descending(list))
				printLine("The numbers are in descending order");
			else
				printLine("The numbers are in random order");
		}
		scan.close();
	}
	
	public static boolean ascending(List<Integer> array) {
		for (int i = 1; i < array.size(); i++)
			if (array.get(i) <= array.get(i - 1))
				return false;
		return true;
	}
	
	public static boolean descending(List<Integer> array) {
		for (int i = 1; i < array.size(); i++)
			if (array.get(i) >= array.get(i - 1))
				return false;
		return true;
	}

	public static void print(Object... o) {
		for (Object obj : o) {
			System.out.print(obj);
		}
	}

	public static void printLine(Object... o) {
		if (o.length <= 0) {
			System.out.println();
			return;
		}
		for (Object obj : o) {
			System.out.println(obj);
		}
	}

	public static void printF(boolean newLine, String format, Object... o) {
		System.out.printf(format + ((newLine) ? "\n" : ""), o);
	}

}
