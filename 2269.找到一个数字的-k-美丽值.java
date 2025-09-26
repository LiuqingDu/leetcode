/*
 * @lc app=leetcode.cn id=2269 lang=java
 *
 * [2269] 找到一个数字的 K 美丽值
 */

// @lc code=start
class Solution {
    public int divisorSubstrings(int num, int k) {
        // 转字符串处理
        String s = String.valueOf(num);
        int count = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            int subNum = Integer.parseInt(sub);
            if (subNum != 0 && num % subNum == 0) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

