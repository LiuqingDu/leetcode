/*
 * @lc app=leetcode.cn id=1395 lang=java
 *
 * [1395] 统计作战单位数
 */

// @lc code=start
class Solution {
    public int numTeams(int[] rating) {
        
        int n = rating.length;
        int totalTeams = 0;

        // 只有 3 个及以上的士兵才能组建作战单位
        if (n < 3) return 0;

        // i < j < k，所以中间人 j 的范围是 1 到 n-2
        for (int j = 1; j < n - 1; j++) {
            int leftLess = 0;
            int leftGreater = 0;
            int rightLess = 0;
            int rightGreater = 0;

            // 1. 统计 j 左边的元素 (0 到 j-1)
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftLess++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            // 2. 统计 j 右边的元素 (j+1 到 n-1)
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightLess++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }

            // 3. 计算以 j 为中心能够组成的作战单位数，并累加
            totalTeams += (leftLess * rightGreater) + (leftGreater * rightLess);
        }

        return totalTeams;
    }
}
// @lc code=end

