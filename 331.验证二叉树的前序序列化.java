/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start

class Solution {
    public boolean isValidSerialization(String preorder) {

        // https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solutions/651132/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/

        String[] cs = preorder.split(",");

        Stack<String> stack = new Stack();

        for (int i = 0; i < cs.length; i++) {
            stack.add(cs[i]);
            while(stack.size() >= 3 
                && "#".equals(stack.get(stack.size() - 2)) 
                && "#".equals(stack.get(stack.size() - 1))
                && !"#".equals(stack.get(stack.size() - 3))) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.add("#");
            }
        }

        return stack.size() == 1 && stack.get(0).equals("#");
    }
}
// @lc code=end

