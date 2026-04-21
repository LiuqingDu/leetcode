/*
 * @lc app=leetcode.cn id=1300 lang=java
 *
 * [1300] 转变数组后最接近目标值的数组和
 */

// @lc code=start
class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;

        int left = 0, right = arr[n - 1];
        int ans = 0;
        int bestDiff = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = getSum(arr, mid);

            int diff = Math.abs(sum - target);

            if (diff < bestDiff || (diff == bestDiff && mid < ans)) {
                bestDiff = diff;
                ans = mid;
            }

            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // 计算截断后的数组和
    private int getSum(int[] arr, int value) {
        int sum = 0;
        for (int x : arr) {
            sum += Math.min(x, value);
        }
        return sum;
    }
}
// @lc code=end

