/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
    int n = seq.length();
    int[] res = new int[n];
    int depth = 0;

    for (int i = 0; i < n; i++) {
        char c = seq.charAt(i);

        if (c == '(') {
            depth++;
            res[i] = depth % 2;  // 奇偶分配
        } else {
            res[i] = depth % 2;  // 先分配
            depth--;
        }
    }

    return res;
    }
}
// @lc code=end

