/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            char c = letters[mid];
            if (c < target) {
                left = mid + 1;
            } else if (c == target) {
                left = mid + 1;
            } else if (c > target) {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }
}
// @lc code=end

