/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        // 类似三数之和的题目
        // 为了避免重复的三边组合
        // 规定三边依次增大, a <= b <= c
        // 由于以上三边大小关系,必然满足 b+c > a 和 a+c > b
        // 因此只需要保证 a+b > c即可
        // 那么需要先对数组排序
        // 然后先确定第三边,再用双指针寻找其余两边
        // 这里要注意,先固定的第三边必须是最大边 c
        // 如果先固定小边,比如 a
        // 那么当 a+b < c的时候, 有可能是因为 b 太小,也可能是因为 c 太大
        // 无法确定应该移动哪一个指针

        Arrays.sort(nums);
        int ans = 0;
        for (int k = nums.length - 1; k > 1; k--) {
            
            // 用双指针法检查可能的三角形组合
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // 在 a 和 b 之间的所有值都可以当做 a 来跟 b 匹配
                    ans += (j - i);
                    // 移动 b
                    j--;
                } else {
                    // a b 之间的值都不能当做 a 来匹配当前的 b
                    i++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

