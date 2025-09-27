/*
 * @lc app=leetcode.cn id=2231 lang=java
 *
 * [2231] 按奇偶性交换后的最大数字
 */

// @lc code=start
class Solution {
    public int largestInteger(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 选择排序
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 只有奇偶相同才交换
                if (((arr[i] - arr[j]) % 2 == 0) && arr[i] < arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return Integer.parseInt(new String(arr));
    }
}
// @lc code=end

