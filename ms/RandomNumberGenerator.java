package ms;

public class RandomNumberGenerator {

	static int findCeil(int arr[], int r, int l, int h) {
		int mid;
		while (l < h) {
			mid = l + ((h - l) >> 1); // Same as mid = (l+h)/2
			if (r > arr[mid])
				l = mid + 1;
			else
				h = mid;
		}
		return (arr[l] >= r) ? l : -1;
	}

	static int myRand(int arr[], int freq[], int n) {
		int prefix[] = new int[n], i;
		prefix[0] = freq[0];
		for (i = 1; i < n; ++i)
			prefix[i] = prefix[i - 1] + freq[i];
		int r = ((int) (Math.random() * (323567)) % prefix[n - 1]) + 1;
		int indexc = findCeil(prefix, r, 0, n - 1);
		return arr[indexc];
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4 };
		int freq[] = { 10, 5, 20, 100 };
		int i, n = arr.length;
		for (i = 0; i < 5; i++)
			System.out.println(myRand(arr, freq, n));
	}

}
