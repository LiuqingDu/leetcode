/*
 * @lc app=leetcode.cn id=2335 lang=java
 *
 * [2335] 装满杯子需要的最短总时长
 */

// @lc code=start
class Solution {
    public int fillCups(int[] amount) {
        // 追求最优解那么就要尽可能每次都装两杯
        // 那么最好情况就是总杯数/2
        // 但是当其中一种杯数比另外两种杯数之和还要大的时候
        // 最后就不能每次都两杯了
        // 此时这种最大杯数就是最终结果
        // res = Max(a,b,c,(a+b+c+1)/2)
        // java不能同时比较多个数字,就先排序一下
        // 看最大的数是不是大于另外两个之和

        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
// @lc code=end

