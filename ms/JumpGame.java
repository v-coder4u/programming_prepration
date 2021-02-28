package ms;

import java.util.*;

public class JumpGame {

	public static boolean canReach(int nums[], int start) {
		if (nums[start] == 0) {
			return true;
		}
		Set<Integer> visited = new HashSet<>();
		visited.add(start);
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		while (queue.size() > 0) {
			int curr = queue.poll();
			if (nums[curr] == 0) {
				return true;
			}
			int index = curr - nums[curr];
			if (index >= 0 && !visited.contains(index)) {
				visited.add(index);
				queue.offer(index);
			}
			index = curr + nums[curr];
			if (index < nums.length && !visited.contains(index)) {
				visited.add(index);
				queue.offer(index);
			}
		}
		return false;
	}
	
	
	//dfs
	public boolean canReach2(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];
        
        return canReach(arr, start, visited);
    }
    
    private boolean canReach(int[] arr, int start, boolean[] visited) {
        var x = arr[start];
        if(arr[start] == 0) return true;
        if(!visited[start]){
            visited[start] = true;
            if(start - arr[start] >= 0 && canReach(arr, start - arr[start], visited)) return true;
            if(start + arr[start] <= arr.length - 1 && canReach(arr, start + arr[start], visited)) return true ;
        }
        return false;
    }

	
	
}
