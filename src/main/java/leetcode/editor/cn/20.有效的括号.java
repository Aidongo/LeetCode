/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char c;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == '(') {
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

