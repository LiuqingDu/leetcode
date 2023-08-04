/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start

class Solution {
    // 回溯
    // 注意返回的结果不能包含重复的组合，[1,2] 和 [2,1]是重复的
    // 所以每次选数字应当从上一个选的数字后面开始选，就可以避免重复
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    List<Integer> current = new LinkedList<Integer>();
    int k;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        // 初始从数字1开始选择k个数字
        backtrack(1);
        return res;
    }

    // 方法表示从数字pick开始选择
    private void backtrack(int pick) {
        // 如果已经选出k个数字则添加结果并返回
        if (current.size() == k) {
            res.add(new LinkedList<Integer>(current));
            return;
        }

        // 从当前选择数字开始往后选择
        // pick依照题目从1开始
        for (int i = pick; i <= n; i++) {
            current.add(i);
            backtrack(i + 1);
            current.remove(current.size() - 1);
        }
    }
}
// @lc code=end

