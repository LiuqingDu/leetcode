/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        // 如果没有4和9这种特例，那么其实有点类似买东西找钱的时候，
        // 一般都会偏向优先拿面额大的钞票，这样凑出来的钱张数最小。
        // 这样比如6块钱就会凑出5+1，但是4就会凑成1+1+1+1，不符合要求，
        // 可以把4和9这种特殊情况也当作一种面额，这样就比较方便处理。

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romas = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 13是字库的长度，理解为钞票的面额，从面额大的开始拿
        while (i < 13) {
            // 如果当前要拿的数字大于等于当前面额，那么这张钞票/这个数字可以拿
            while (num >= nums[i]) {
                sb.append(romas[i]);
                // 拿完以后把面额减掉，剩下的是还没有凑出来的
                num -= nums[i];
            }
            // 当前面额比剩下的数字大了，不能拿当前面额了，尝试下一张更小面额的
            i++;
        }

        return sb.toString();
    }
}
// @lc code=end

