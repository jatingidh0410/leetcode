class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countTarget = 0, lessTarget = 0;
        for (int num : nums) {
            if (num < target) lessTarget++;
            if (num == target) countTarget++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < countTarget; i++)
            result.add(lessTarget + i);
        return result;
    }
} 