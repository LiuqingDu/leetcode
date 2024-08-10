/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] arr = new boolean[128];
        for (int i = 0; i < jewels.length(); i++) {
            arr[jewels.charAt(i)] = true;
        }

        int res = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (arr[stones.charAt(i)]) {
                res++;
            }
        }

        return res;
    }
}
// @lc code=end

