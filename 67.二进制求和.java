/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        // 进位
        int c = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            // 本轮计算结果
            int s = c;
            s += i >= 0 ? a.charAt(i) - '0' : 0;
            s += j >= 0 ? b.charAt(j) - '0' : 0;
            // 当前位
            sb.append(s % 2);
            // 进位
            c = s / 2;
        }

        sb.append(c == 1 ? '1' :"");
        return sb.reverse().toString();

    }
}
// @lc code=end

