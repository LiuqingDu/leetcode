/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        // 很明显，如果把数组排序后分为两半，设中值为x，一半小于等于x记为A，一半大于等于x记为B
        // 然后把A按顺序放在偶数位置上，B放在奇数位置上
        // 那么可以得出相邻的两个数必定一个小于等于x，一个大于等于x
        // 另外，可以看出A中等于x的数必定会放在末尾，而B中等于x的必定放在头部
        // 一般来说，这两组x不会相遇，那么数组里相邻的数就只能是大于或者小于关系
        // 但当x的个数刚好等于一半的时候，它们就会相遇
        // 这里解决方法是，把A和B反序之后再依次放入数组就可以避免
        // 原因可以这样思考：本来A和B如果是并排放置，那么x刚好是错开的，
        // 也就是A和B对应位置上最多只有一个x，不会有两个x，最多是x相邻
        // 但是现在A和B是交错放置，且实际上是A往左偏一点，B往右偏一点，然后交叉放置
        // 这样原本A末尾的x和B开头的x就会放在一起
        // A [a1,a2,x ,x ]
        // B [x ,x, b1,b2]
        // 上面这样错开后，两个x就会相遇
        // 如果把A和B翻转
        // A [x ,x ,a2,a1]
        // B [b2,b1,x ,x ]
        // 这样再把B往右偏一点，就会使得两部分x远离，也就不会相遇了

        // 这里可以排序，也可以使用桶
        // 使用桶，最多5001个数字
        int N = 5001;
        int[] bucket = new int[N];

        // 每个元素的索引对应一个数字，元素自身表示这个数字有几个
        for (int num: nums) {
            bucket[num]++;
        }

        int n = nums.length;
        // 这里应该把桶里的A和B翻转
        // 但这里倒着从末尾取数字也就相当于翻转了
        // 从桶的最后一个开始取，也就是从B开始取
        int j = N - 1;
        // 依次先放奇数位，因为先取的是B
        for (int i = 1; i < n; i+=2) {
            // 在桶里找到下一个数字
            while (bucket[j] == 0) {
                j--;
            }
            // 把这个数字放到nums里
            nums[i] = j;
            // 可用数字-1
            bucket[j]--;
        }
        for (int i = 0; i < n; i+=2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }

    }
}
// @lc code=end

