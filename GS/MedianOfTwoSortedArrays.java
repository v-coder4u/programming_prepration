package gs;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalSize = nums1.length + nums2.length;
		int[] result = new int[totalSize];
		int i = 0, j = 0, idx = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				result[idx++] = nums1[i++];
			} else {
				result[idx++] = nums2[j++];
			}
		}

		while (i < nums1.length) {
			result[idx++] = nums1[i++];
		}

		while (j < nums2.length) {
			result[idx++] = nums2[j++];
		}

		if (totalSize % 2 != 0)
			return (double) result[totalSize / 2];

		return (double) (result[(totalSize - 1) / 2] + result[totalSize / 2]) / 2.0;
	}
}
