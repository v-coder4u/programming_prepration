package dp;

import java.util.Arrays;
import java.util.Scanner;

public class RussianDollEnvelopes {

	public static int maxEnvelopes(int[][] envelopes) {
		Envelop[] envelops = new Envelop[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			envelops[i] = new Envelop(envelopes[i][0], envelopes[i][1]);
		}
		Arrays.sort(envelops);
		int[] dp = new int[envelopes.length];
		int totalMax = 0;
		for (int i = 0; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (envelops[j].h < envelops[i].h && envelops[j].w < envelops[i].h) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			if (dp[i] > totalMax) {
				totalMax = dp[i];
			}
		}
		return totalMax;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfElements = sc.nextInt();
		int[][] envelopes = new int[numberOfElements][2];
		for (int i = 0; i < numberOfElements; i++) {
			for (int j = 0; j < 2; j++) {
				envelopes[i][j] = sc.nextInt();
			}
		}
		System.out.println("The maximum number of envelopes you can Russian doll is : " + maxEnvelopes(envelopes));
	}
}

class Envelop implements Comparable<Envelop> {
	int w;
	int h;

	Envelop(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public int compareTo(Envelop o) {
		return this.w - o.w;
	}
}
