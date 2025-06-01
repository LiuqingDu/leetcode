/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
    public String customSortString(String order, String s) {
        // 首先统计每个字母出现次数
        // 然后根据 order 的顺序依次把对应字母按其次数加在结果串后
        // 最后把剩余字母加在最后

        // 统计每个字母次数
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        // 把 order 内每个字母根据其次数添加到结果串后
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }

        // 把剩余字母加在结果后
        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return ans.toString();
    }
}
// @lc code=end

