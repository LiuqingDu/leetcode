/*
 * @lc app=leetcode.cn id=1684 lang=java
 *
 * [1684] 统计一致字符串的数目
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // 用一个 int 的 32 位来表示每个字母是否出现过
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        // 统计每个字符串出现的字符
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            // 取或与目标 mask 比较,如果有不在 mask 内的,则会导致结果不等于 mask
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

