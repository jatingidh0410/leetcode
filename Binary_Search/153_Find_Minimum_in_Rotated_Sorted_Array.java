class Solution {
    public int findMin(int[] nums) {
       // Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum element is in the right half
                left = mid + 1;
            } else {
                // The minimum element is in the left half or at mid
                right = mid;
            }
        }

        // At the end of the loop, left and right will point to the minimum element
        return nums[left];
    }
}