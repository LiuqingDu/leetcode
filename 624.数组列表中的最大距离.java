/*
 * @lc app=leetcode.cn id=624 lang=java
 *
 * [624] 数组列表中的最大距离
 */

// @lc code=start
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // 可以看出实际上每一个数组的最大值和最小值才是有用的
        // 数组又排序过,所以每个数组只有第一个和最后一个才有用
        // 我们依次遍历每一个数组, 并维护一个全局的最大值和最小值
        // 每一个数组,它与之前的站点能形成的最大距离,应当是它的最大值减去全局最小值
        // 或者是它的最小值减去全局最大值
        // 然后跟当前记录的最大结果比较
        // 最后更新全局最大值最小值

        int min = arrays.get(0).getFirst();
        int max = arrays.get(0).getLast();
        int res = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int curMin = arrays.get(i).getFirst();
            int curMax = arrays.get(i).getLast();
            // 更新最大结果
            // 首先用当前数组的最大值和最小值分别跟全局的最小值最大值来算出
            // 当前数组可以形成的最大结果
            // 然后跟全局的最结果对比
            res = Math.max(res,
                Math.max(Math.abs(curMax - min), Math.abs(curMin - max)));
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
        }
        return res;
    }
}
// @lc code=end

