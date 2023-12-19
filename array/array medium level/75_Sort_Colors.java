// Given an array nums with n objects colored red, white, or blue, 
// sort them in-place so that objects of the same color are adjacent, 
// with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
class Solution {
    public int[] sortColors(int[] nums) {
        // Using TreeMap to count occurrences of each color
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        
        // Counting occurrences of each color
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        // Sorting colors in-place based on their occurrences
        int j = 0;
        // Count of red (color 0)
        int zeroCount = hm.getOrDefault(0, 0);
        
        // Filling the array with red (color 0)
        for (; j < zeroCount; j++) {
            nums[j] = 0;
        }
        
        j = zeroCount;
        // Count of white (color 1)
        int oneCount = hm.getOrDefault(1, 0);
        
        // Filling the array with white (color 1)
        for (; j < zeroCount + oneCount; j++) {
            nums[j] = 1;
        }
        
        j = zeroCount + oneCount;
        // Filling the array with blue (color 2)
        for (; j < nums.length; j++) {
            nums[j] = 2;
        }
        
        // Returning the sorted array
        return nums;
    }
}