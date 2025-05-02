/*
 * @lc app=leetcode.cn id=1662 lang=java
 *
 * [1662] 检查两个字符串数组是否相等
 */

// @lc code=start
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    public String join(String[] words) {
        StringBuilder ret = new StringBuilder();
        for (String s : words) {
            ret.append(s);
        }
        return ret.toString();
    }
}
// @lc code=end

