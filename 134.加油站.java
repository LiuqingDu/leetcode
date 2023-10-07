/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    // 因为到达一个点i后，在去下一个点i+1之前，当前站点i的油gas[i]其实是没有用的
    // 也就是说，gas[i]和cost[i]这两个值表示能否去到站点i+1的
    // 具体来说，就是站点0是必定可以到达的，能否到达站点1，取决于gas[0]和cost[0]
    // 能否到达站点2，取决于gas[1]和cost[1]，以及出发前油箱还剩多少油
    // 那么就需要一个变量记录油箱还剩多少油
    // 现在假设允许赊欠油，也就是允许油箱为负数，这样跑一圈之后，找到油箱最小值的那一个站点
    // 这个站点表示如果从它之前一站开过来油箱会降到最低，不会再比它更低了，
    // 那么如果从这个站点当出发点，其它所有站点都不会比他低，也就满足可以跑完所有站点

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        // 表示到达一个站点后，还剩多少油。以及历史上最小的油量，这个最小值对应应当出发的站点
        int sum = 0, minSum = 0;
        // 表示应当从哪个站点出发
        int start = 0;

        // 假设从第一个站点出发，也就是首先到达第一个站点，
        // 到达第一个站点后，油箱油量为0，start指向0，对应minSum的0
        for (int i = 0; i < n; i++) {
            // 表示从站点i出发，到达站点i+1后，还剩多少油
            sum = sum + gas[i] - cost[i];
            if (sum < minSum) {
                // 如果到达站点i+1后，油量到达了新低，那么就应该从这个站点i+1出发
                minSum = sum;
                start = i + 1;
            }
        }

        // 这个sum在累加完之后，相当于所有油的总和再减去所有油耗
        // 如果这个值为负数，说明所有油加起来都不够开一圈的
        if (sum < 0) {
            return -1;
        }

        // 注意start取值是i+1，而i取值是[0,n)，所以start取值是[1,n]，对应站点索引还需要-1
        if (start == n) {
            return 0;
        } else {
            return start;
        }


    }
}
// @lc code=end

