/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 用差分数组
        // 差分数组用来记录原数组相邻两个元素的差值
        // 比如需要对原数组索引[2, 4]之间的数均+10
        // 则对应差分数组只需要在索引为2的元素上+10，然后在索引为5的元素上-10即可
        // 这样差分数组就表示，从第二个元素开始，数字+10，第三个元素相对第二个元素不变（因为差分数组第三个元素还是0）
        // 直到第五个元素，再把前一个数字数字-10得到第五个元素
        // 这样实现了到第四个元素都是+10的

        // 差分数组，默认为0。差分多一个位子是因为最后一个位子用来恢复差分的操作的，最终结果用不到
        int[] offset = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            // 存储的航班编号从1开始，但数组索引从0开始，这里有个把航班编号-1的位移
            offset[bookings[i][0] - 1] += bookings[i][2];
            // 需要把编号-1作为位移，但是又需要在结尾位置的下一个位置恢复这个差分值，所以是-1+1=0
            offset[bookings[i][1]] -= bookings[i][2];
        }
        // 把差分数组恢复成原数组
        int[] res = new int[n];
        // 先恢复第一个，因为后面的元素依赖于前一个元素
        res[0] = offset[0];
        for (int i = 1; i < n; i++) {
            // 第二个元素开始，每一个元素等于前一个元素加上当前位的差分值
            res[i] = res[i - 1] + offset[i];
        }
        return res;
    }
}
// @lc code=end

