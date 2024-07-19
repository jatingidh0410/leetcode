class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Find the minimum element in each row
        for (int i = 0; i < rows; i++) {
            int minVal = matrix[i][0];
            int minIdx = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minIdx = j;
                }
            }
            
            // Check if the minimum element in the row is the maximum in its column
            boolean isMaxInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minIdx] > minVal) {
                    isMaxInCol = false;
                    break;
                }
            }
            
            // If it is, add to the list of lucky numbers
            if (isMaxInCol) {
                luckyNumbers.add(minVal);
            }
        }
        
        return luckyNumbers;
    }
}