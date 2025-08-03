/*
 * @lc app=leetcode.cn id=2078 lang=java
 *
 * [2078] 两栋颜色不同且距离最远的房子
 */

// @lc code=start
class Solution {
    public int maxDistance(int[] colors) {
        // 注意要最大距离,那么应当尽量把两端向外扩展
        // 那么最大距离应当要么是从左侧第一个元素出发到右侧某个元素结束
        // 要么是右侧第一个元素出发到左侧某个元素结束
        // 然后比较这两头出发的哪个大
        int n = colors.length;
        int left = 0, right = n - 1;
        
        while (right >= 0 && colors[0] == colors[right]) {
            right--;
        }
        while (left < n && colors[n - 1] == colors[left]) {
            left++;
        }
        // 因为题目保证存在不同颜色,所以直接判断最大距离
        return Math.max(n - 1 - left, right);
    }
}
// @lc code=end

