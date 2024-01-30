class Solution {
    public int bouquetFormed(int[] bloomDay, int day, int conFlower) {
        int bouquet = 0;
        int temp = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                temp += 1;
            } else {
                bouquet += temp / conFlower;
                temp = 0;
            }
        }
        bouquet += temp / conFlower;
        return bouquet;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = -1;
        
        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int bouquet = bouquetFormed(bloomDay, mid, k);
            
            if (bouquet >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}
