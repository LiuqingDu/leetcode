/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    LinkedList<Integer> track = new LinkedList<Integer>();
    // 标记数字是否用过
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        // 对元素首先排序，可以避免重复的组合
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 找出所有组合可能，那么也就是选择树里的每一个节点都要加到结果里
        res.add(new LinkedList(track));
        // 下面的判断可以不要，到底了就返回
        if (start == nums.length) {
            return;
        }

        // 避免找到重复的组合，每次只能往后选择，前面的不选
        for (int i = start; i < nums.length; i++) {
            // 这里类似47题
            // 对于重复的数字，避免它们形成重复组合的关键是，它们的初始位置不能移动
            // 比如[1, 2, 2']，另一个组合[1, 2', 2]跟它是一样的，问题就在于两个相同的数字换了位置
            // 也被当作是一个新的组合了，那么保证相同数字的顺序的方法就是，必须依次取它们
            // 对于相同的数字，必须前面的同一个数字被选择了，当前这个同数字才可以选择，
            // 这样就保证了选择的数字是严格按照初始的顺序来的，避免了重复
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, i + 1);
            track.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

