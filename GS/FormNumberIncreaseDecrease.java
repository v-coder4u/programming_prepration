package gs;

public class FormNumberIncreaseDecrease {
	static String getMinNumberForPattern(String seq) {
		int n = seq.length();
		if (n >= 9)
			return "-1";
		char result[] = new char[n + 1];
		int count = 1;
		for (int i = 0; i <= n; i++) {
			if (i == n || seq.charAt(i) == 'I') {
				for (int j = i - 1; j >= -1; j--) {
					result[j + 1] = (char) ((int) '0' + count++);
					if (j >= 0 && seq.charAt(j) == 'I')
						break;
				}
			}
		}
		return new String(result);
	}
}

//static void PrintMinNumberForPattern(String arr) {
//	int curr_max = 0;
//	int last_entry = 0;
//	int j;
//
//	for (int i = 0; i < arr.length(); i++) {
//		int noOfNextD = 0;
//		switch (arr.charAt(i)) {
//		case 'I':
//			j = i + 1;
//			while (j < arr.length() && arr.charAt(j) == 'D') {
//				noOfNextD++;
//				j++;
//			}
//			if (i == 0) {
//				curr_max = noOfNextD + 2;
//				System.out.print(" " + ++last_entry);
//				System.out.print(" " + curr_max);
//				last_entry = curr_max;
//			} else {
//				curr_max = curr_max + noOfNextD + 1;
//				last_entry = curr_max;
//				System.out.print(" " + last_entry);
//			}
//
//			for (int k = 0; k < noOfNextD; k++) {
//				System.out.print(" " + --last_entry);
//				i++;
//			}
//			break;
//
//		case 'D':
//			if (i == 0) {
//				j = i + 1;
//				while (j < arr.length() && arr.charAt(j) == 'D') {
//					noOfNextD++;
//					j++;
//				}
//				curr_max = noOfNextD + 2;
//				System.out.print(" " + curr_max + " " + (curr_max - 1));
//				last_entry = curr_max - 1;
//			} else {
//				System.out.print(" " + (last_entry - 1));
//				last_entry--;
//			}
//			break;
//		}
//	}
//	System.out.println();
//}