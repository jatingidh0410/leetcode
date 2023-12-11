// I will start by checking if the input array nums contains only one element; if it does, there's nothing to move, so I'll return early. Otherwise, I'll initialize a variable nonZeroIndex to keep track of the position where the next non-zero element should be placed.

// I will then iterate through the array using a for loop. For each element, if it's non-zero, I will copy it to the nonZeroIndex position in the array and increment nonZeroIndex. This process effectively shifts all non-zero elements to the front of the array while preserving their original order.

// Finally, I'll fill the remaining positions in the array (from nonZeroIndex to the end) with zeros using a while loop.

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

         while(nonZeroIndex<nums.length){
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
}