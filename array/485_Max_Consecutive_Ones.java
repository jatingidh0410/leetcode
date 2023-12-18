/*
 * Initialization:
maxSum: Keeps track of the maximum consecutive ones encountered so far.
sum: Keeps track of the current consecutive ones. It is updated during the iteration.
Iterate Through the Array:
For each element n in the array nums, perform the following steps.
Update Current Sum:
Multiply the current sum (sum) by the current element n. This has the effect of resetting the sum to zero if a zero is encountered.
Add to Current Sum:
Add the current element n to the sum. This accumulates consecutive ones.
Update Maximum Sum:
Update the maxSum with the maximum value between the current maxSum and the updated sum. This ensures that maxSum always holds the maximum consecutive ones encountered so far.
Repeat:
Repeat steps 3-5 for each element in the array.
Return Maximum Sum:
The final result is stored in the variable maxSum, representing the maximum number of consecutive ones in the array.
 */

 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int ans = 0, sum = 0;
        for (int n : nums) {
            sum *= n;
            sum += n;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}