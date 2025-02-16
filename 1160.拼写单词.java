/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }

        int res = 0;
        for (String word : words) {
            if (canForm(word, map)) {
                res += word.length();
            }            
        }

        return res;
    }

    private boolean canForm(String word, int[] map) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > map[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

