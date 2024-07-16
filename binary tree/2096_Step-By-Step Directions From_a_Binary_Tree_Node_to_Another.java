import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> pathToStart = new ArrayList<>();
        List<Character> pathToDest = new ArrayList<>();
        
        // Find paths from root to startValue and destValue
        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);
        
        // Find the divergence point
        int i = 0;
        while (i < pathToStart.size() && i < pathToDest.size() && pathToStart.get(i) == pathToDest.get(i)) {
            i++;
        }
        
        // Number of 'U' steps to go up to the common ancestor
        StringBuilder result = new StringBuilder();
        for (int j = i; j < pathToStart.size(); j++) {
            result.append('U');
        }
        
        // Add the remaining steps to the destination
        for (int j = i; j < pathToDest.size(); j++) {
            result.append(pathToDest.get(j));
        }
        
        return result.toString();
    }
    
    private boolean findPath(TreeNode root, int value, List<Character> path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        
        // Try left subtree
        path.add('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.remove(path.size() - 1); // Backtrack if not found in left
        
        // Try right subtree
        path.add('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.remove(path.size() - 1); // Backtrack if not found in right
        
        return false;
    }
}
