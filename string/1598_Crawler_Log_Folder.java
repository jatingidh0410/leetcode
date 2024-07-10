class Solution {
    public int minOperations(String[] logs) {
        int depth = 0; // Initialize the current folder depth

        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--; // Move up one level, but not below 0
                }
            } else if (log.equals("./")) {
                // Stay in the same folder, do nothing
            } else {
                depth++; // Move down one level for a child folder
            }
        }
        
        return depth; 
        // The depth is the number of operations needed to return to the main folder
    }
}
