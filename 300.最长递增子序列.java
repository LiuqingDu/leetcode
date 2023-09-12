/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    // 动态规划，定义dp[i]表示以nums[i]这个数字结尾的串，最大的子序列长度
    // 也就是说dp[i]的值，对应的串至少包含nums[i]这一个数字，所以长度至少为1
    // 那么dp[i]的值，取决于nums[i]前面有没有比nums[i]更小的数字，如果有，那么就可以跟nums[i]组成一个更长的串
    // 如果组成了，那么dp[i]就是这个长度+1，如果没有组成，dp[i]还是默认的1

    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     // dp[i]表示以nums[i]结尾的串的最大子序列长度
    //     int[] dp = new int[n];
    //     // 子序列长度至少为1
    //     Arrays.fill(dp, 1);

    //     // 从第二个dp开始计算，因为第一个dp肯定是1不会变
    //     for (int i = 1; i < n; i++) {
    //         // 每个dp的值取决于nums[i]之前所有的数
    //         for (int j = 0; j < i; j++) {
    //             // 如果nums[i]前面有比它更小的数，那么就可以组成更长的串
    //             if (nums[j] < nums[i]) {
    //                 // 长度等于找到的前面的串长度+1，然后再取最大值
    //                 dp[i] = Math.max(dp[i], dp[j] +1);
    //             }
    //         }
    //     }

    //     // dp[i]记录的是每一个以nums[i]结尾的串的最大子序列长度，
    //     // 本题要的结果是dp中的最大值
    //     int res = 1;
    //     for (int i = 0; i < n; i++) {
    //         if (dp[i] > res) {
    //             res = dp[i];
    //         }
    //     }
    //     return res;

    // }

    // 二分法，具体看labuladong题解
    // 大致意思如下：
    // 把nums看作是一组扑克牌，从左往右依次把一张牌按照下面规则放置到牌堆中
    // 1. 每堆牌只能把小牌放在大牌顶部
    // 2. 如果当前牌堆顶部的牌比当前的一张牌要小，那么跟右边的牌堆比较
    // 3. 如果所有牌堆都比较完了，那么就在最右边创建一个新牌堆，牌放在这里
    // 4. 当多个牌堆的顶牌都比当前牌大的时候，放在最左边的牌堆上
    // 这样把牌都放完之后，牌堆的个数就是最大递增子序列长度，
    // 每个牌堆顶的牌组成一个递增序列
    // 二分法就出现在手上的牌在当前牌堆中找合适的位置，因为牌堆顶始终是递增的，也就可以用二分法
    // 实质是二分法找左区间
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 记录每堆牌的顶部的牌面，最多有n堆牌
        int[] top = new int[n];
        // 记录有多少堆牌了，也可以表示下一堆牌的索引
        int piles = 0;

        for(int i = 0; i < n; i++) {
            // 要处理的牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 是左闭右开的区间，right=piles, piles指向的是下一堆，是不存在的
            // 注意这里是找左区间，套用二分法模板要注意
            while(left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    // 注意右边是开区间，所以这里right可以等于mid
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    // 寻找左区间，右边界要向左靠近
                    right = mid;
                }
            }
            // 如果左边界走到最右边也没找到，那么就需要开辟一个新堆
            if (left == piles) {
                piles++;
            }
            // 把当前牌放到牌堆顶
            top[left] = poker;
        }

        // 有多少牌堆，最大序列长度就是多少，从每个牌堆顶拿一张牌就组成一个序列
        return piles;
    }
}
// @lc code=end

