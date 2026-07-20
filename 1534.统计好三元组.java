/*
 * @lc app=leetcode.cn id=1534 lang=java
 *
 * [1534] 统计好三元组
 */

// @lc code=start
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        
        int n = arr.length, cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ++cnt;
                    }
                }
            }
        }
        return cnt;

    }
}
// @lc code=end

