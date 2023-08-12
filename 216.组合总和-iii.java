/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {

    // 记录最终结果、当前选择的结果
    private List<List<Integer>> res = new LinkedList<List<Integer>>();
    private List<Integer> track = new LinkedList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 0, 0);
        return res;
    }

    // 选择k个数字使得和为n，sum为当前已经累计的和，cur是最后一个选择的数字
    private void backtrack(int k, int n, int sum, int cur) {
        // 如果和已经超出则直接返回
        if (sum > n) {
            return;
        }
        // 只有个数等于k且和等于n的时候才满足
        if (track.size() == k && sum == n) {
            res.add(new LinkedList<Integer>(track));
            return;
        }
        // 其他情况就是还没满足，从已选择的数字的下一个数字开始继续选
        for (int i = cur + 1; i <=9; i++) {
            track.add(i);
            sum+=i;
            backtrack(k, n, sum, i);
            track.remove(track.size() - 1);
            sum-=i;
        }
    }
}
// @lc code=end

