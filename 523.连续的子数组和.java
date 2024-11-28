/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 前缀和
        // 假设存在子区间 [i, j] 的和是 k 的倍数
        // 那么索引为 i-1 的前缀和对 k 取余
        // 等于索引为 j 的前缀和对 k 取余
        // 可以这么理解, i-1 的前缀和对 k 取余记为 x
        // 由于区间 [i,j] 的和是 k 的倍数
        // 那么子区间的和对 k 取余等于 0
        // 那么 i-1 的前缀和再加上子区间就等于 j 的前缀和
        // 所以 j 的前缀和对 k 取余也等于 x
        // 首先算出所有前缀和
        // 由于子区间长度至少为 2
        // 我们从第二个元素开始,把往左两位的前缀和加入 set
        // 它再往左的前缀和已经在之前加过了,每次只需要加这一个左两位的就可以
        // 如果 set 里存在跟当前前缀和取余相同的,这就是 i-1 的前缀和
        // 它们之间就是 [i,j] 区间

        int n = nums.length;
        // 所有前缀和,第一个元素是没有任何元素的前缀和,因此长度+1
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        // 从第二个元素开始,因为区间长度至少为2
        for (int i = 2; i <= n; i++) {
            // 把它左侧两位的那个前缀和取余,并加入 set
            // 再往左的前缀和在之前已经加入过了
            set.add(sum[i - 2] % k);
            // 如果存在跟当前前缀和取余相同的,那么就存在子区间符合题目
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

