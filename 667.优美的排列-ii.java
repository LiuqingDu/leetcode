/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        // 对于 n 可以取的数字范围是 [1, n]
        // 那么 k 可以取的范围是 [1, n-1]
        // 观察规律, 假设 n=6
        // 当 k=1 时
        // 1,2,3,4,5,6
        // 差值均为 1
        // k=2
        // 1,6,5,4,3,2
        // 差值 5,1,1,1,1
        // k=3
        // 1,6,2,3,4,5
        // 差值 5,4,1,1,1
        // k=4
        // 1,6,2,5,4,3,2
        // 差值 5,4,3,1,1,1
        // 可以看出是前 k 个数字是依次从两端取数字
        // 剩下的再沿第 k 个数字那头继续取完剩下的数字

        int left = 1, right = n;
        int[] res = new int[n];
        // 记录当前填充到第几个数字
        int index = 0;
        // 先填充前 k 个
        for (int i = 0; i < k; i++) {
            // 从左边取一个数字填充
            if (i % 2 == 0) {
                res[index] = left;
                index++;
                left++;
            } else {
                // 从右边
                res[index] = right;
                index++;
                right--;
            }
        }

        // 从左边或者右边把剩下数字填充进去
        if (k % 2 == 0) {
            while (left <= right) {
                res[index] = right;
                index++;
                right--;
            }
        } else {
            while (left <= right) {
                res[index] = left;
                index++;
                left++;
            }
        }

        return res;
    }
}
// @lc code=end

