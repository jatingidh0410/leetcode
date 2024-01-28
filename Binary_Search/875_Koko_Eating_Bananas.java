class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum eating speed
        int right = 0; // Maximum eating speed
        
        // Find the maximum number of bananas in a pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, h, mid)) {
                // If Koko can finish eating within h hours at speed mid or less
                // We search for smaller speeds
                right = mid;
            } else {
                // If Koko cannot finish eating within h hours at speed mid
                // We search for higher speeds
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // Helper function to check if Koko can finish eating within h hours at speed k
    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        
        for (int pile : piles) {
            // Calculate the hours needed to finish eating from the current pile
            hours += (pile + k - 1) / k;
        }
        
        return hours <= h;
    }
}
