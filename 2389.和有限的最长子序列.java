/*
 * @lc app=leetcode.cn id=2389 lang=java
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums);  // 先排序 nums
        int n = nums.length;

        // 计算前缀和
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int m = queries.length;
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int q = queries[i];
            // 二分查找前缀和中 <= q 的最大下标
            int left = 0, right = n - 1;
            int idx = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (prefix[mid] <= q) {
                    idx = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            answer[i] = idx + 1; // 长度 = 下标+1
        }

        return answer;
    }
}
// @lc code=end

