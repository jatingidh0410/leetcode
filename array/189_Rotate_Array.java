/*Input:

Takes an array (nums) and an integer (k) indicating the rightward rotation steps.
Length Determination:

Finds the length of the array (n).
Create New Array:

Creates a new array (result) to store rotated elements.
Calculate New Indices:

Determines new indices for elements after rotation.
Store Rotated Elements:

Places elements at their new indices in the result array.
Copy Back:

Copies rotated elements from result back to the original array (nums).
Result:

The original array is rotated to the right by k steps.
 */


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        
        System.arraycopy(result, 0, nums, 0, n);
    }
}
