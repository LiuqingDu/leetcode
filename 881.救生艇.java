/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // 每组人都不超过limit,那么最差的结果是每组人一条船
        // 为了船最少,就需要把人最少的那组人放到有空位的地方去
        // 因为一条船最多两组,所以对于人数少的每一组只需要考虑一次
        // 为了最好的结果,人最少的那组应该和尽量多的那组人合并
        // 一旦合并这条船就不用再考虑了
        // 先排序,然后双指针
        // 如果最大的那组和最小的组可以合并,就合并为一条船
        // 如果不可以,那么就大的那组单独上船,这船就不能再跟其他组合并了,
        // 因为已经尝试过最小组了
        // 当前最小组留着跟接下来的大组尝试合并

        Arrays.sort(people);
        int res = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            // 如果可以合并,则记一条船,移动两个指针
            if (people[left] + people[right] <= limit) {
                res++;
                left++;
                right--;
            } else {
                // 否则大的上船,移动大指针
                res++;
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

