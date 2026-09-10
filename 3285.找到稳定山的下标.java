/*
 * @lc app=leetcode.cn id=3285 lang=java
 *
 * [3285] 找到稳定山的下标
 */

// @lc code=start
class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        return result;

    }
}
// @lc code=end

