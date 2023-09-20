/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start

import java.util.LinkedList;

class Solution {

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    LinkedList<Integer> track = new LinkedList<Integer>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {

        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums);
        return res;
    }

    private void backtrace(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 当存在重复元素，又要找它们的排列时，问题就在于，
            // 相同的元素交换位置，就会被当作一个全新的排列
            // 比如[1,2,2']和[1,2',2]这两个2位置不同就会被当作两个排列，
            // 解决的办法就是要确保相同元素在排列中的顺序不能变，必须按照在数组中的顺序
            // 也就是要确保2'必须在2后面，
            // 方法就是按预先固定好的顺序取它们，也就是说，如果要取2',那么2必须已经取过了
            // 由于元素是排序过的，那么只要判断【前一个元素如果跟当前元素相同，
            // 那么只有前者used了，才可以选择当前元素，否则就跳过】
            // 下面的判断就是如果相同，但前者没用过，就跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            track.add(nums[i]);
            backtrace(nums);
            used[i] = false;
            track.removeLast();
        }
    }
}
// @lc code=end

