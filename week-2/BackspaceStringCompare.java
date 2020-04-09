import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac". Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "". Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c". Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b". Note:
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters. Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 */
public class BackspaceStringCompare {
    // solution 1
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        char backspace = '#';

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != backspace)
                stack1.push(S.charAt(i));
            else if (S.charAt(i) == backspace && !stack1.isEmpty())
                stack1.pop();
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != backspace)
                stack2.push(T.charAt(i));
            else if (T.charAt(i) == backspace && !stack2.isEmpty())
                stack2.pop();
        }
        if (stack1.size() != stack2.size())
            return false;

        while (!stack1.isEmpty()) {
            if (stack1.pop() == stack2.pop())
                continue;
            else
                return false;
        }
        return true;
    }

    // solution 2
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        char backspace = '#';
        int index = 0; // tracks index of char to be deleted

        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (temp != backspace) {
                s.append(temp);
                index++;
            } else if (s.length() != 0 && temp == backspace)
                s.deleteCharAt(--index);
        }
        index = 0;
        for (int i = 0; i < T.length(); i++) {
            char temp = T.charAt(i);
            if (temp != backspace) {
                t.append(temp);
                index++;
            } else if (t.length() != 0 && temp == backspace)
                t.deleteCharAt(--index);
        }
        return (s.toString().equals(t.toString()));
    }
}