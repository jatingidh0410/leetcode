/*
Objective:
We are given an array where every number appears twice, except for one number that appears only once.
We need to find and return that unique number.

Approach:
We use a variable called store and set it to 0.
Loop through the Array:
We go through each number in the array.
For each number, we perform a special operation called XOR with the current value of store.
XOR is like a switch: if the bits are different, it turns on (1), if the bits are the same, it turns off (0).
Why XOR?

Because XOR has a special property: a ^ a = 0 (switching on and off cancels out).
So, when numbers appear twice, their XOR cancels out to 0, leaving only the unique number in the end.

Return Result:
The final value of store after XORing all the numbers is the unique number we were looking for.
We return this unique number.

Benefits:
This approach works in a single pass through the array, making it efficient.
It uses very little extra memory (constant space).
 */
class Solution {
    public int singleNumber(int[] nums) {
        int store = 0;
        for (int i = 0; i < nums.length; i++) {
            store ^= nums[i];
        }
        return store;
    }
}