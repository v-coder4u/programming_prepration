package ms;

import java.util.Scanner;

public class LargestSumContiguousSubarray {

	static int maxSubArraySum(int a[], int size) {
		int msf = 0, meh = 0;
		for (int i = 0; i < size; i++) {
			meh += a[i];
			if (meh < 0) {
				meh = 0;
			} else if (msf < meh) {
				msf = meh;
			}
		}
		return msf;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(maxSubArraySum(arr, n));
	}

}
