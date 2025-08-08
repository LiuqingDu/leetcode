/*
 * @lc app=leetcode.cn id=2094 lang=java
 *
 * [2094] 找出 3 位偶数
 */

// @lc code=start
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // 统计每个数字的出现次数
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }

        List<Integer> ans = new ArrayList<>();
        // 枚举三位数的每一位
        dfs(0, 0, cnt, ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // i=0 百位，i=1 十位，i=2 个位，x 表示当前正在构造的数字
    private void dfs(int i, int x, int[] cnt, List<Integer> ans) {
        if (i == 3) {
            ans.add(x);
            return;
        }
        for (int d = 0; d < 10; d++) {
            if (cnt[d] > 0 && (i == 0 && d > 0 || i == 1 || i == 2 && d % 2 == 0)) {
                cnt[d]--; // 消耗一个数字 d
                dfs(i + 1, x * 10 + d, cnt, ans);
                cnt[d]++; // 复原
            }
        }
    }
}
// @lc code=end

