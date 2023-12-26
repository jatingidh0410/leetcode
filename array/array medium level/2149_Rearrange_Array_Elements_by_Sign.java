/*
Separate positive and negative integers into two arrays.
Interleave the positive and negative integers.
Ensure the modified array starts with a positive integer.
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        // Separate positive and negative integers
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        // Interleave positive and negative integers
        int[] result = new int[nums.length];
        int i = 0;
        int posIndex = 0;
        int negIndex = 0;

        while (i < nums.length) {
            if (i % 2 == 0 && posIndex < positive.size()) {
                result[i] = positive.get(posIndex++);
            } else if (negIndex < negative.size()) {
                result[i] = negative.get(negIndex++);
            }
            i++;
        }

        return result;
    }
}
