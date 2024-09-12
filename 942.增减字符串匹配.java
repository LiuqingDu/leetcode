/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String s) {
        // 每次都从剩余的数字的两端取就可以
        // 如果是 I，说明要求当前数字要小，从剩下的数字中取最小的就可以
        // 反之如果是 D 那么取剩下的最大数就可以了

        int n = s.length();
        int[] res = new int[n + 1];
        int l = 0;
        int r = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = l;
                l++;
            } else {
                res[i] = r;
                r--;
            }
        }
        res[n] = l;
        return res;
    }
}
// @lc code=end

