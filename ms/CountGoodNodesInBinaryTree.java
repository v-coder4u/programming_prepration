package ms;

public class CountGoodNodesInBinaryTree {

	public int goodNodes(TreeNode root) {
		return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
	}

	int dfs(TreeNode node, int max) {
		if (node == null)
			return 0;
		int count = 0;
		if (node.val >= max) {
			count++;
			max = node.val;
		}
		return count + dfs(node.left, max) + dfs(node.right, max);
	}

}
