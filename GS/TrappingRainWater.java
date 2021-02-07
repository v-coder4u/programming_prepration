package gs;

public class TrappingRainWater {

	public int trap(int[] height) {
		if (height.length <= 1)
			return 0;
		int leftPos = 0;
		int rightPos = height.length - 1;
		int leftMax = height[leftPos];
		int rightMax = height[rightPos];
		int totalWaterTrapped = 0;

		while (leftPos < rightPos) {
			if (height[leftPos] < height[rightPos]) {
				leftPos++;
				leftMax = Math.max(leftMax, height[leftPos]);
				totalWaterTrapped += leftMax - height[leftPos];
			} else if (height[leftPos] >= height[rightPos]) {
				rightPos--;
				rightMax = Math.max(rightMax, height[rightPos]);
				totalWaterTrapped += rightMax - height[rightPos];
			}
		}

		return totalWaterTrapped;
	}
}
