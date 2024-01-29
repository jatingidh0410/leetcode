class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        
        // Iterate through each element in arr1
        for (int num1 : arr1) {
            // Check if there is no element in arr2 such that |num1 - num2| <= d
            boolean isValid = true;
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break;
                }
            }
            // If there is no such element in arr2, increment count
            if (isValid) {
                count++;
            }
        }
        
        return count;
    }
}
