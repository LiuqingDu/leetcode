/*
 * @lc app=leetcode.cn id=2586 lang=java
 *
 * [2586] 统计范围内的元音字符串数
 */

// @lc code=start
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end

