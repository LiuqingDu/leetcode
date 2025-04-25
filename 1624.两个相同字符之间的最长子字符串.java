/*
 * @lc app=leetcode.cn id=1624 lang=java
 *
 * [1624] 两个相同字符之间的最长子字符串
 */

// @lc code=start
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // 记录每个字母第一次出现的位置,当后续再次遇到时
        // 计算这个字母之间的长度,并更新最大长度

        // 每个字母第一次位置
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        // 最大长度
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            // 第一次遇到
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                // 不是第一次,计算该字母之间长度,并更新最大值
                maxLength = Math.max(maxLength, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLength;
    }
}
// @lc code=end

