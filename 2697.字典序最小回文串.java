/*
 * @lc app=leetcode.cn id=2697 lang=java
 *
 * [2697] 字典序最小回文串
 */

// @lc code=start
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                arr[left] = arr[right] = (char) Math.min(arr[left], arr[right]);
            }
            ++left;
            --right;
        }
        return new String(arr);
    }
}
// @lc code=end

