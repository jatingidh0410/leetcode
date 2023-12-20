/*
The code begins by sorting the array nums in non-decreasing order using the sort function. This rearranges the elements such that identical elements are grouped together.
Once the array is sorted, the majority element will always be present at index n/2, where n is the size of the array.
This is because the majority element occurs more than n/2 times, and when the array is sorted, it will occupy the middle position.
The code returns the element at index n/2 as the majority element.
The time complexity of this approach is O(n log n) since sorting an array of size n takes O(n log n) time.
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}