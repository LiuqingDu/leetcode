/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {

    // 这道题是在第300题的基础上来的，对于一堆信封，看能不能套起来，
    // 首先把它们按照宽度从小到大排序，想象一下现实中这种情况，
    // 假设宽度较小的在顶部，较大的在底部
    // 它们的左边是对齐的，则右边是依次往右变大的，
    // 因为信封不能翻转，所以当下宽度已经排序的情况下，这个顺序不能再改变，否则就套不下，
    // 那么最终的套法肯定是现在这个宽度排序的子序列，
    // 这时如果需要判断一个信封是否能装下另一个，那么就需要它的高度在当前顺序下是递增的，
    // 把它们此时的高度作为一个数组，找到这个数组的最大递增子序列，就是最终结果
    // 计算这个子序列的方法就是第300题
    // 注意：在按宽度排序的时候，当两个信封的宽度相同时，它们需要按照高度降序排列
    // 这样是为了确保在寻找高度的递增序列时，同一宽度的信封，最多只有一个信封进入递增序列，
    // 因为宽度相同的信封不能互相套，选了其中一个，剩下的同宽度信封都不能选，
    // 既然是找高度的递增序列，那么把同宽度的信封按高度递减排序，就可以保证一旦选了一个，剩下的都不会选到

    public int maxEnvelopes(int[][] envelopes) {

        // 先把信封按照宽度递增排序，如果宽度相同，则按高度递减排序
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[]b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        int n = envelopes.length;
        // 保存排序后的宽度
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        // 从宽度中寻找递增子序列的最大长度
        return lengthOfLIS(height);
    }

    // 第300题解法，这里用二分法，具体看labuladong题解
    // 因为有的测试用例会在dp方法上超时，dp的复杂度为O(n^2)，二分复杂度为O(logn)
    private int lengthOfLIS(int[] nums) {
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

    // 第300题的方法，计算一个数组中最长递增子序列的长度
    // private int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 1);

    //     // 计算每一个dp[i]，dp[i]表示以nums[i]结尾的数字序列可以组成的最长递增子序列的长度
    //     for (int i = 1; i < n; i++) {
    //         // 对于dp[i]，如果nums[i]前面有比nums[i]小的数，那么它们就可以组成新的递增序列
    //         // dp[i]就是这个递增序列的长度+1，然后再取最大值
    //         for (int j = 0; j < i; j++) {
    //             if (nums[j] < nums[i]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //     }

    //     // 比较所有的子序列长度，返回最大值
    //     int res = 1;
    //     for (int i = 0; i < n; i++) {
    //         if (res < dp[i]) {
    //             res = dp[i];
    //         }
    //     }

    //     return res;

    // }
}
// @lc code=end

