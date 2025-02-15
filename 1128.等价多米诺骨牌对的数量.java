/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // 可以先把每张牌按照左小右大的顺序摆放好
        // 这样只需要比较左边相同且右边相同即可,无需或另一种交换位置情况
        // 注意到牌的点数小于等于 9, 那么一张牌可以用两位数来表示
        // 用长度 100 的数组可以表示所有的牌, 然后统计每张牌的数量即可

        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            // 统一表示为两位数
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            // 每多一张牌,就可以跟已有的牌分别组成一组
            // 那么总数就增加已有的数量
            ret += num[val];
            // 此牌数量+1
            num[val]++;
        }
        return ret;
    }
}
// @lc code=end

