/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
class Solution {
    // 一组数字,每个数字表示权重
    // 数字之和 sum 就是总权重
    // 每一个数字可以看做是其中的一个区间,或者是其中一部分
    // 或者说,每个数字表示它有多少张奖券
    // 数字越大奖券越多,也就更容易中奖
    // 在总奖池里抽一个奖券,对应编号属于哪个数字,就是依照权重抽中那个数字
    // 那么每个数字所对应的奖券编号可以从第一个数字依次分发
    // 比如原数组 [3,1,2,4]
    // 分发的奖券编号的区间为
    // [1,3], [4,4], [5,6], [7,10]
    // 注意到每一个数字所持有的奖券编号的起始相当于它前面的数字和+1
    // 也就是前缀和+1
    // 奖券编号的末尾值相当于包含当前数字的前缀和
    // 当抽到一个奖券编号后,可以用二分法找到它所在的那个区间,也就是它对应的那个数字

    int[] pre;
    int total;

    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        total = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
            total += w[i];
        }
    }
    
    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        // low, high 表示两侧的指针
        while (low < high) {
            int mid = (high - low) / 2 + low;
            // 如果中点的前缀和比目标小,那么目标在中点右侧
            // 注意这里 pre 前缀和是包含当前数字nums[i]的
            // 所以如果比前缀和大,那么目标数字至少也是在右侧那个数字上
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                // 否则目标数字可能是当前数字或者它左边,此时移动右指针
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

