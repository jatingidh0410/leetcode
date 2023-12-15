/*
 * We know that the summation of the first N numbers is (N*(N+1))/2. 
 * We can say this S1. Now, in the given array, 
 * every number between 1 to N except one number is present. 
 * So, if we add the numbers of the array (say S2), 
 * the difference between S1 and S2 will be the missing number. 
 * Because, while adding all the numbers of the array, 
 * we did not add that particular number that is missing.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
       int totalSum = n*(n+1)/2;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum = sum+nums[i]; 
        }
        return totalSum - sum;
    }
}