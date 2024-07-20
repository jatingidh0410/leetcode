class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = value;
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }
        return matrix;
    }
}
// Get the number of rows and columns from the lengths of rowSum and colSum arrays
// Initialize a 2D array (matrix) to store the result
// Iterate over each row
// Iterate over each column within the current row
// Determine the value to be placed in matrix[i][j]
// This value is the minimum of the remaining row sum and column sum
// Assign the calculated value to the current cell of the matrix
// Subtract the assigned value from the remaining sum of the current row
// Subtract the assigned value from the remaining sum of the current column
// Return the constructed matrix