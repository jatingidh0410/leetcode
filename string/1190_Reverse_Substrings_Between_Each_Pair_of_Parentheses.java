import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Push the current string onto the stack and start a new one
                stack.push(current);
                current = new StringBuilder();
            } else if (ch == ')') {
                // Reverse the current string and append it to the previous one
                current.reverse();
                current = stack.pop().append(current);
            } else {
                // Append the current character to the current string
                current.append(ch);
            }
        }

        return current.toString();
    }
}
