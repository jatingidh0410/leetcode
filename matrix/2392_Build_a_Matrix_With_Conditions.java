class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Get the topological order for rows and columns
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        
        // If either order is invalid (contains a cycle), return an empty matrix
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }
        
        // Create a position map for quick lookup of column positions
        int[] colPosition = new int[k + 1];
        for (int j = 0; j < k; j++) {
            colPosition[colOrder.get(j)] = j;
        }
        
        // Initialize the result matrix
        int[][] matrix = new int[k][k];
        
        // Place each number in the matrix based on the row and column orders
        for (int i = 0; i < k; i++) {
            int num = rowOrder.get(i);
            matrix[i][colPosition[num]] = num;
        }
        
        return matrix;
    }
    
    private List<Integer> topologicalSort(int k, int[][] conditions) {
        // Initialize graph and in-degree array
        List<Integer>[] graph = new List[k + 1];
        int[] inDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph and update in-degrees
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }
        
        // Initialize the queue with nodes having 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Perform Kahn's algorithm for topological sorting
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If the order contains all k elements, return it; otherwise, return an empty list
        return order.size() == k ? order : new ArrayList<>();
    }
}