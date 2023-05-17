package balanced_parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        BalancedParenthesis bp = new BalancedParenthesis();
        System.out.println(bp.isBalancedParenthesis(")("));
        System.out.println(bp.isBalancedParenthesis("((({{{[[[]]]}}})))"));
        System.out.println(bp.isBalancedParenthesis("{{{[][][]}}}"));
        System.out.println(bp.isBalancedParenthesis("()(){{{}}}[][]"));
        System.out.println(bp.isBalancedParenthesis("()()()()"));
        System.out.println(bp.isBalancedParenthesis("(((())})"));
        System.out.println(bp.isBalancedParenthesis(")((()))()()"));
        System.out.println(bp.isBalancedParenthesis("((()()()))(()"));
    }

    public boolean isBalancedParenthesis(String s) {
        Map<String, String> m = new HashMap<>();
        m.put("{", "}");
        m.put("(", ")");
        m.put("[", "]");
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = "" + s.charAt(i);
            if (m.containsKey(s1)) {
                stack.push(m.get(s1));
            } else {
                if (stack.isEmpty() || !s1.equals(stack.pop())) {
                    return false;
                }
            }
        }
        return true;
    }

}
