/*
 * @lc app=leetcode.cn id=809 lang=java
 *
 * [809] 情感丰富的文字
 */

// @lc code=start
class Solution {
    public int expressiveWords(String s, String[] words) {
        // 把字符串 t 扩张成 s 的过程
        // 双指针分别指向两个字符串第一个字符
        // 这两个起始字符必须相同
        // 然后滑动指针直到两个指针字符分别与它前一个字符不同
        // 统计这两段路程的字符长度, 分别记为 cnts 和 cntt
        // 首先要保证 cnts >= cntt
        // 如果 cnts == cntt, 那么无需扩张
        // 如果 cnts > cntt, 那么需要保证 cnts >= 3, 才能扩张
        // 当两个指针同时到达字符串末尾时, 说明两个字符串匹配成功

        int ans = 0;
        for (String word : words) {
            if (isExpressive(s, word)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isExpressive(String s, String word) {
        int i = 0, j = 0;
        // 双指针遍历两个字符串
        while (i < s.length() && j < word.length()) {
            // 如果两个指针指向的字符不相同, 直接返回 false
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            // 统计连续相同字符的个数
            int cnts = 1, cntt = 1;
            // 统计 s 中连续相同字符的个数
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                cnts++;
                i++;
            }
            // 统计 word 中连续相同字符的个数
            while (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                cntt++;
                j++;
            }
            // 如果 cnts < cntt, 说明 s 中的字符不够扩张, 返回 false
            // 如果 cnts > cntt, 需要保证 cnts >= 3, 才能扩张
            // 如果 cnts == cntt, 无需扩张, 直接继续
            if (cnts < cntt || (cnts > cntt && cnts < 3)) {
                return false;
            }
            i++;
            j++;
        }
        return i == s.length() && j == word.length();
    }
    // 时间复杂度 O(n * m), n 为 s 的长度, m 为 words 中所有单词的平均长度
    // 空间复杂度 O(1), 只使用了常数级别的额外空间
}
// @lc code=end

