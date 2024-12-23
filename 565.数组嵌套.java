/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        // 题目意思是对于 nums[i], 它指向 nums[nums[i]]
        // 就是每一个元素指向以当前元素为索引的元素
        // 因为每个元素都不重复,所以可以得出每一个元素都指向独一无二的元素
        // 每个元素也只被一个元素指进来
        // 可以看出整个数组必定形成一个或者多个环,且环不会交叉
        // 元素指向自身也看作一个环
        // 那么依次从每一个元素出发,直到回到最初的元素为止,这就是一个环
        // 计算每一个环的长度,比较出最大的长度
        // 因为一个元素只能出现在一个环当中,不会重复出现,
        // 可以把访问过的元素标记一下,比如记为 -1 这个不会存在的数字

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            // 如果已经访问过则跳过
            if (nums[i] == -1) {
                continue;
            }

            // 环长度
            int size = 0;
            // 开始遍历环,记录环上当前的索引
            int currentIndex = i;
            // 当前元素还未访问时前进
            while (nums[currentIndex] != -1) {
                // 先获取下一个元素, 因为当前元素要用来标记已访问过
                int nextIndex = nums[currentIndex];
                // 把当前元素标记为已访问,避免重复遍历
                nums[currentIndex] = -1;
                // 指向下一个元素
                currentIndex = nextIndex;
                size++;
            }

            res = Math.max(res, size);
        }
        return res;
    }
}
// @lc code=end

