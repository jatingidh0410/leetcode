/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1]; // Use an array to store the count as a reference
        dfs(root, distance, result);
        return result[0];
    }
    
    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return new int[distance + 1];
        }
        
        if (node.left == null && node.right == null) {
            int[] leafDist = new int[distance + 1];
            leafDist[1] = 1; // Distance 1 from itself
            return leafDist;
        }
        
        int[] leftDists = dfs(node.left, distance, result);
        int[] rightDists = dfs(node.right, distance, result);
        
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                result[0] += leftDists[i] * rightDists[j];
            }
        }
        
        int[] currentDists = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDists[i + 1] = leftDists[i] + rightDists[i];
        }
        
        return currentDists;
    }
}
