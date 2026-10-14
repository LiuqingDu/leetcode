/*
 * @lc app=leetcode.cn id=1477 lang=java
 *
 * [1477] 找两个和为目标值且不重叠的子数组
 */

// @lc code=start
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int n = arr.length, s = 0, ans = n + 1, minL = n;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (pos.containsKey(s - target)) {
                int j = pos.get(s - target), len = i - j;
                ans = Math.min(ans, len + (j == -1 ? n : arr[j]));
                minL = Math.min(minL, len);
            }
            arr[i] = minL;
            pos.put(s, i);
        }
        return ans == n + 1 ? -1 : ans;

    }
}
// @lc code=end

