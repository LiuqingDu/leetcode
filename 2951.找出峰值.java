/*
 * @lc app=leetcode.cn id=2951 lang=java
 *
 * [2951] 找出峰值
 */

// @lc code=start
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i< mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

