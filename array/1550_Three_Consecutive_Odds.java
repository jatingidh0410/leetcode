class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0; // Counter for consecutive odds
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) { // Check if the number is odd
                count++; // Increment count for consecutive odds
                if (count == 3) {
                    return true; // Found three consecutive odds
                }
            } else {
                count = 0; // Reset count if we encounter a non-odd number
            }
        }
        
        return false; // Did not find three consecutive odds
    }
}
