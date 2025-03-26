/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> res = new ArrayList<Boolean>(candies.length);
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}
// @lc code=end

