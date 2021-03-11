package paypal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountVowelsPermutation {

	public static int countVowelPermutation(int n) {

		long[][] dp = new long[n + 1][5];
		Arrays.fill(dp[1], 1);

		// 0: a ------ 1: e ----- 2: i ----- 3: o-----4: u

		for (int i = 1; i < n; i++) {
			dp[i + 1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % 1_000_000_007;
			dp[i + 1][1] = (dp[i][0] + dp[i][2]) % 1_000_000_007;
			dp[i + 1][2] = (dp[i][3] + dp[i][1]) % 1_000_000_007;
			dp[i + 1][3] = (dp[i][2]) % 1_000_000_007;
			dp[i + 1][4] = (dp[i][2] + dp[i][3]) % 1_000_000_007;
		}

		long ans = 0;
		for (int i = 0; i < 5; i++)
			ans = (ans + dp[n][i]) % 1_000_000_007;
		return (int) ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countVowelPermutation(n));
	}
	
	public int countVowelPermutation2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 5;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : "aeiou".toCharArray()) {
            freqMap.put(ch, 1);
        }
        Map<Character, char[]> matchMap = new HashMap<>();
        matchMap.put('a', new char[]{'e'});
        matchMap.put('e', new char[]{'a','i'});
        matchMap.put('i', new char[]{'a', 'e', 'o', 'u'});
        matchMap.put('o', new char[]{'i', 'u'});
        matchMap.put('u', new char[]{'a'});
        
        for (int i = 2; i <= n; i++) {
            Map<Character, Integer> freqMapNew = new HashMap<>();
            for (Character ch : "aeiou".toCharArray()) {
                int count = freqMap.get(ch);
                for (Character ch1 : matchMap.get(ch)) {
                    freqMapNew.put(ch1, (freqMapNew.getOrDefault(ch1, 0) + count) % 1000000007);
                }
            }
            freqMap = new HashMap<>(freqMapNew);
        }
        
        int res = 0;
        for (int freq : freqMap.values()) {
            res = (res + freq) % 1000000007;
        }
        
        return res;      
    }

}
