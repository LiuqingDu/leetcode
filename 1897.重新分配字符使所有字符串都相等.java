/*
 * @lc app=leetcode.cn id=1897 lang=java
 *
 * [1897] 重新分配字符使所有字符串都相等
 */

// @lc code=start
class Solution {
    public boolean makeEqual(String[] words) {
        // 因为可以执行任意步操作, 且操作可以移动任意字母到任意位置
        // 实际上分配并不是问题,问题是字母的数量能否均分
        // 统计每个字母次数,该次数必须能被 words.length 整除

        int[] count = new int[26]; // 统计26个字母的总频率

        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }

        int n = words.length;
        for (int freq : count) {
            if (freq % n != 0) {
                return false; // 有字符不能平均分配
            }
        }

        return true; // 所有字符都能平均分配
    }
}
// @lc code=end

