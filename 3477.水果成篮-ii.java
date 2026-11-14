/*
 * @lc app=leetcode.cn id=3477 lang=java
 *
 * [3477] 水果成篮 II
 */

// @lc code=start
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int count = 0;
        int n = baskets.length;
        for (int fruit : fruits) {
            int unset = 1;
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    unset = 0;
                    break;
                }
            }
            count += unset;
        }
        return count;

    }
}
// @lc code=end

