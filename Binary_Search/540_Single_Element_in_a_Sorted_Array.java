class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Make mid point to the first element of the pair
            if (mid % 2 == 1) {
                mid--;
            }
            
            // Check if the single element is on the left or right side
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }

        return nums[left];
    }
}
