/*
Initialize index to 0, which represents the current position for the next non-target element.
Iterate through each element of the input array using the i pointer.
For each element nums[i], check if it is equal to the target value.
If nums[i] is not equal to val, it means it is a non-target element.
Set nums[index] to nums[i] to store the non-target element at the current index position.
Increment index by 1 to move to the next position for the next non-target element.
Continue this process until all elements in the array have been processed.
Finally, return the value of index, which represents the length of the modified array. */

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
