package gs;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int result = 0;
		while (i < j) {
			int numberOfElements = j - i;
			result = Math.max(result, numberOfElements * Math.min(height[i], height[j]));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return result;
	}
}
