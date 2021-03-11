package paypal;

public class FrequencyOfASubstring {

	static int countFreq(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int res = 0;

		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}

			if (j == M) {
				res++;
				j = 0;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String txt = "dhimanman";
		String pat = "man";
		System.out.println(countFreq(pat, txt));
		// 2
	}

	int KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int lps[] = new int[M];
		int j = 0; // index for pat[]

		computeLPSArray(pat, M, lps);

		int i = 0; // index for txt[]
		int res = 0;
		int next_i = 0;

		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				j = lps[j - 1];
				res++;
				if (lps[j] != 0)
					i = ++next_i;
				j = 0;
			}

			else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		return res;
	}

	void computeLPSArray(String pat, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				if (len != 0) {
					len = lps[len - 1];
				} else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
