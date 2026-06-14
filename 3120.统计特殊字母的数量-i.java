/*
 * @lc app=leetcode.cn id=3120 lang=java
 *
 * [3120] 统计特殊字母的数量 I
 */

// @lc code=start
class Solution {
    public int numberOfSpecialChars(String word) {
        
        Set<Character> s = new HashSet<>();
        for (char c : word.toCharArray()) {
            s.add(c);
        }
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.contains(c) && s.contains((char)(c - 'a' + 'A'))) {
                ans++;
            }
        }
        return ans;

    }
}
// @lc code=end

