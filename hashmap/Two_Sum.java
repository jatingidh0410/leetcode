class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the complement and its index
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement is in the hashmap
            if (numMap.containsKey(complement)) {
                // If found, return the indices
                return new int[]{numMap.get(complement), i};
            }

            // Add the current element and its index to the hashmap
            numMap.put(nums[i], i);
        }

        // No solution found, throw an exception
        throw new IllegalArgumentException("No two elements add up to the target.");
    }
    
}