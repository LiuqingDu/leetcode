/*
 * @lc app=leetcode.cn id=2399 lang=java
 *
 * [2399] 检查相同字母间的距离
 */

// @lc code=start
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstIndex[charIndex] == 0) {
                firstIndex[charIndex] = i + 1; // Store index + 1 to differentiate from default 0
            } else {
                int expectedDistance = distance[charIndex];
                int actualDistance = i - (firstIndex[charIndex] - 1) - 1;
                if (expectedDistance != actualDistance) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

