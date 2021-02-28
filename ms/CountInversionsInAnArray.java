package ms;

import java.util.Arrays;

public class CountInversionsInAnArray {

	static int getSum(int BITree[], int index) {
		int sum = 0;
		while (index > 0) {
			sum += BITree[index];
			index -= index & (-index);
		}
		return sum;
	}

	static void updateBIT(int BITree[], int n, int index, int val) {
		while (index <= n) {
			BITree[index] += val;
			index += index & (-index);
		}
	}

	static void convert(int arr[], int n) {
		int[] temp = new int[n];
		for (int i = 0; i < n; i++)
			temp[i] = arr[i];
		Arrays.sort(temp);
		for (int i = 0; i < n; i++) {
			arr[i] = lower_bound(temp, 0, n, arr[i]) + 1;
		}
	}

	static int lower_bound(int[] a, int low, int high, int element) {
		while (low < high) {
			int middle = low + (high - low) / 2;
			if (element > a[middle])
				low = middle + 1;
			else
				high = middle;
		}
		return low;
	}

	static int getInvCount(int arr[], int n) {
		int invcount = 0;
		convert(arr, n);
		int[] BIT = new int[n + 1];

		for (int i = 1; i <= n; i++)
			BIT[i] = 0;

		for (int i = n - 1; i >= 0; i--) {
			invcount += getSum(BIT, arr[i] - 1);
			updateBIT(BIT, n, arr[i], 1);
		}
		return invcount;
	}

	public static void main(String[] args) {
		int arr[] = { 8, 4, 2, 1 };
		int n = arr.length;
		System.out.print("Number of inversions are : " + getInvCount(arr, n));
	}

}
