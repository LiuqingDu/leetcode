/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;

        int[] count = new int[128];

        // 统计字符数量
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        // 如果已经平衡
        if (count['Q'] == target && count['W'] == target
                && count['E'] == target && count['R'] == target) {
            return 0;
        }

        int left = 0;
        int res = n;

        for (int right = 0; right < n; right++) {

            count[s.charAt(right)]--;

            while (left < n &&
                    count['Q'] <= target &&
                    count['W'] <= target &&
                    count['E'] <= target &&
                    count['R'] <= target) {

                res = Math.min(res, right - left + 1);

                count[s.charAt(left)]++;
                left++;
            }
        }

        return res;
    }
}
// @lc code=end

