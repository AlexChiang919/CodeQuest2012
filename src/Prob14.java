import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Prob14 {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader(Prob14.class.getName() + ".in.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		StringTokenizer st = new StringTokenizer(scan.readLine(), ";");
		String start = st.nextToken();
		String dest = st.nextToken();
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
		HashMap<String, HashMap<String, Integer>> dis = new HashMap<>();
		while (scan.ready()) {
			StringTokenizer line = new StringTokenizer(scan.readLine(), ";");
			HashMap<String, Integer> path = new HashMap<>();
			HashMap<String, Integer> d = new HashMap<>();
			String from = line.nextToken();
			String to = line.nextToken();
			int cost = Integer.parseInt(line.nextToken());
			if (graph.containsKey(from)) {
				path = graph.get(from);
				d = dis.get(from);
			}
			path.put(to, cost);
			d.put(to, 1000000);
		}
		printLine(graph, dis, start, dest);
		scan.close();
	}
	
	public static String bofus(HashMap<String, HashMap<String, Integer>> graph, HashMap<String, HashMap<String, Integer>> dis, String start, String dest) {
		Queue<String> q = new LinkedList<>();
		
		while (!q.isEmpty()) {
			
		}
		return "";
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
