/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new LinkedList<List<Integer>>();
    private List<Integer> track = new LinkedList<Integer>();
    private boolean[] options = new boolean[10];

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i <= 9; i++) {
            options[i] = true;
        }
        backtrack(k, n, 0, 0);
        return res;
    }

    private void backtrack(int k, int n, int sum, int cur) {
        if (sum > n) {
            return;
        }
        if (track.size() == k && sum == n) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = cur + 1; i <=9; i++) {
            if (options[i]) {
                track.add(i);
                options[i] = false;
                sum+=i;
                backtrack(k, n, sum, i);
                track.remove(track.size() - 1);
                options[i] = true;
                sum-=i;
            }
        }
    }
}
// @lc code=end

