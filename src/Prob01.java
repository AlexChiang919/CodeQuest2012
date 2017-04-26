import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Prob01 {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader(Prob01.class.getName() + ".in.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		BigDecimal money = new BigDecimal("0.00");
		while (scan.ready()) {
			String line = scan.readLine();
			if (!isValid(line))
				continue;
			long value = Long.parseLong(line.substring(line.lastIndexOf('=') + 1));
			if (line.startsWith("H"))
				money = money.add(new BigDecimal("0.50").multiply(new BigDecimal("" + value)));
			else if (line.startsWith("Q"))
				money = money.add(new BigDecimal("0.25").multiply(new BigDecimal("" + value)));
			else if (line.startsWith("D"))
				money = money.add(new BigDecimal("0.10").multiply(new BigDecimal("" + value)));
			else if (line.startsWith("N"))
				money = money.add(new BigDecimal("0.05").multiply(new BigDecimal("" + value)));
			else if (line.startsWith("P"))
				money = money.add(new BigDecimal("0.01").multiply(new BigDecimal("" + value)));
		}
		printLine("$" + money);
		scan.close();
	}

	public static boolean isValid(String line) {
		return line.startsWith("HALFDOLLAR") || line.startsWith("QUARTER") || line.startsWith("DIME")
				|| line.startsWith("NICKEL") || line.startsWith("PENNY");
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
