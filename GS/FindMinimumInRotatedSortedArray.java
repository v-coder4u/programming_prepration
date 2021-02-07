package gs;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MAX_VALUE;
		}
		int pivot = nums[0];
		int index = nums.length - 1;
		while (index > 0 && nums[index] < pivot) {
			index--;
		}

		return nums[(index + 1) % nums.length];
	}
}

//public int findMin(int[] nums) {
//    return search(nums, 0, nums.length-1, Integer.MAX_VALUE);
//}
//
//int search(int[] nums, int low, int high, int target){
//    if(low>high){
//        return target;
//    }
//    
//    int mid = (low+high)/2;
//    
//    if(nums[mid] <= target){
//        target = nums[mid];
//    }
//    
//   return  Math.min(search(nums , low, mid-1, target), search(nums , mid+1,high, target));
//}