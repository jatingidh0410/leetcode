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
    public TreeNode createBinaryTree(int[][] descriptions) {
         Map<Integer, TreeNode> nodesMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = nodesMap.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = nodesMap.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            nodesMap.put(parentVal, parentNode);
            nodesMap.put(childVal, childNode);

            children.add(childVal);
        }

        // The root will be the node that is not a child of any node
        TreeNode root = null;
        for (int key : nodesMap.keySet()) {
            if (!children.contains(key)) {
                root = nodesMap.get(key);
                break;
            }
        }

        return root;
    }
}