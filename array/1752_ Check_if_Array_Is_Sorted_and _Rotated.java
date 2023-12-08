/*In Java, the logic remains the same, but there are a few key differences:

The method signature uses int[] instead of vector<int>&.
The length property is used for the array length instead of size().
The modulo operation % is used similarly to the C++ version to simulate rotation. */

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        
        return count <= 1;
    }
}
