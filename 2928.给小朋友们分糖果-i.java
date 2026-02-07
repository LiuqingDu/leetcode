/*
 * @lc app=leetcode.cn id=2928 lang=java
 *
 * [2928] 给小朋友们分糖果 I
 */

// @lc code=start
class Solution {
    public int distributeCandies(int n, int limit) {
        int count = 0;

        // 枚举第一个小朋友拿的糖数
        for (int a = 0; a <= limit; a++) {
            // 枚举第二个小朋友拿的糖数
            for (int b = 0; b <= limit; b++) {
                int c = n - a - b;  // 第三个小朋友

                // 判断第三个是否合法
                if (c >= 0 && c <= limit) {
                    count++;
                }
            }
        }

        return count;
    }
}
// @lc code=end

