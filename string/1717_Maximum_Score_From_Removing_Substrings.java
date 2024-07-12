import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            return maximumPoints(s, 'b', 'a', y, x);
        } else {
            return maximumPoints(s, 'a', 'b', x, y);
        }
    }
    
    private int maximumPoints(String s, char first, char second, int firstPoints, int secondPoints) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        // First pass: remove the higher value substring
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && ch == second) {
                stack.pop();
                score += firstPoints;
            } else {
                stack.push(ch);
            }
        }

        // Collect remaining characters for the second pass
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        remaining.reverse();

        // Second pass: remove the lower value substring
        for (char ch : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && ch == first) {
                stack.pop();
                score += secondPoints;
            } else {
                stack.push(ch);
            }
        }

        return score;
    }
}
