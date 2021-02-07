package gs;

import java.util.*;

public class PrintNumber123AES {
	private static String printNumbers(int[] numbers) {

		ArrayList<Integer> array = new ArrayList<>();
		for (int number : numbers) {
			if (findContainsOneTwoThree(number))
				array.add(number);
		}

		Collections.sort(array);

		StringBuffer strbuf = new StringBuffer();
		Iterator it = array.iterator();

		while (it.hasNext()) {
			int value = (int) it.next();
			if (strbuf.length() > 0)
				strbuf.append(", ");
			strbuf.append(Integer.toString(value));
		}

		return (strbuf.length() > 0) ? strbuf.toString() : "-1";
	}

	private static boolean findContainsOneTwoThree(int number) {

		String str = Integer.toString(number);
		return (str.contains("1") && str.contains("2") && str.contains("3"));
	}
}
