class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> friends = new ArrayList<>();
        
        // Initialize the list of friends
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        
        int currentIndex = 0;
        
        // Continue until only one friend is left
        while (friends.size() > 1) {
            // Find the next friend to be removed
            currentIndex = (currentIndex + k - 1) % friends.size();
            friends.remove(currentIndex);
        }
        
        // The last remaining friend is the winner
        return friends.get(0);
    }
}


// second approch
class Solution {
    public int findTheWinner(int n, int k) {
        // Starting with the base case
        int winner = 0; // When there's only one person (0-based index)

        // Compute the position for each number of people from 2 to n
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        // Convert 0-based index to 1-based index
        return winner + 1;
    }

    // Test cases for the Solution class
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findTheWinner(5, 2));  // Output: 3
        System.out.println(sol.findTheWinner(6, 5));  // Output: 1
    }
}
