class Solution {
    public int removeDuplicates(int[] nums) {
        // Check if the array is empty
        if (nums.length == 0) {
            // If it is, there are no duplicates to remove, return 0
            return 0;
        }

        // Initialize two pointers: i (slow pointer) and j (fast pointer)
        int i = 0; // i points to the last unique element

        // Iterate through the array starting from the second element (j = 1)
        for (int j = 1; j < nums.length; j++) {
            // Check if the current element at index j is different from the element at index i
            if (nums[j] != nums[i]) {
                // Increment the slow pointer i to the next position
                i++;
                // Update the array in-place by assigning the unique element at index j to the new position indicated by i
                nums[i] = nums[j];
            }
        }

        // Return the length of the modified array (count of unique elements)
        return i + 1;
    }
}
