/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start

class Solution {
    public int distributeCandies(int[] candyType) {
        // 其实就是比较n/2和糖果种类的小值
        Set<Integer> set = new HashSet<Integer>();
        for (int t: candyType) {
            set.add(t);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
// @lc code=end

