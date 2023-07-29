/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {

    // 首尾依次互相交换，直到遍历到中点
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n/2; i++) {
            swap(s, i, n - 1 - i);
        }
    }

    private void swap(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}
// @lc code=end

