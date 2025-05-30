/*
 * @lc app=leetcode.cn id=1832 lang=java
 *
 * [1832] 判断句子是否为全字母句
 */

// @lc code=start
class Solution {
    public boolean checkIfPangram(String sentence) {
        // 明显可以用一个 二进制数的每一位来表示对应字母有没有出现过
        // 2^26 - 1 是右边有 26 个 1 的目标数字

        int state = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            state |= 1 << (c - 'a');
        }
        // 1 向左移动 26 位,就是 1 右边有 26 个 0
        // 再 -1 就是右边有 26 个 1
        return state == (1 << 26) - 1;
    }
}
// @lc code=end

