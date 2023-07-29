/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();

        // 双指针，分别指向 s 和 t
        // 依次比较字符是否相等
        // 如果完全匹配，则s的指针最终会指向最后一个字符的下一个位置，也即刚刚超出字符串位置的地方
        int i = 0, j = 0;
        while (i < lens && j < lent) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return (i == lens);
    }
}
// @lc code=end

