/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder("");
        }

        int n = s.length();
        int pos = 0;
        int direction = -1;
        for (int i = 0; i < n; i++) {
            arr[pos].append(s.charAt(i));
            if (pos == 0 || pos == numRows - 1) {
                direction = - direction;
            }
            pos += direction;
        }

        StringBuilder res = new StringBuilder("");
        for (StringBuilder sb : arr) {
            res.append(sb);
        }

        return res.toString();
    }
}
// @lc code=end

