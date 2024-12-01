/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        // 每次给 n-1 个数 +1 相当于给其中一个数字 -1
        // 因为我们是考虑操作次数,而不是操作完之后的数字
        // 有点类似俄罗斯方块
        // 初始每个列都是从底部开始有一些砖块,表示当前数字
        // 每次给 n-1 个列上面堆叠一个砖块,表示+1
        // 只考虑所有砖块的顶部那一层的话,也就是砖块顶部的那层表面
        // 其实放 n-1 个砖块跟抽掉一个砖块后,形成的那层顶面是一样的
        // 最终效果是要这层顶面是平的
        // 所以可以理解为把这些砖块,每次取走一个,使得它们水平的操作次数
        // 也就是让所有数字都变成最小的那一个

        int min = nums[0];
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        // 从总和中减去高度等于最小数的那层砖块,剩下的就是需要的操作步数
        return sum - min * n;
    }
}
// @lc code=end

