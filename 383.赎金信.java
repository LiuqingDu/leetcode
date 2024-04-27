/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        int n = 0;
        for (char c: ransomNote.toCharArray()) {
            if (map[c - 'a'] == 0) {
                n++;
            }
            map[c - 'a']++;
        }

        for (char c: magazine.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] == 0) {
                n--;
            }
        }

        return n == 0;
    }
}
// @lc code=end

