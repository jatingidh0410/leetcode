class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                // If the current element is negative, increment count and move to the next column
                count += m - row;
                col--;
            } else {
                // If the current element is non-negative, move to the next row
                row++;
            }
        }

        return count;
    }
}
