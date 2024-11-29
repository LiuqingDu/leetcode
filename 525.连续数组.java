/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        // 类似 lc 523, 用前缀和, 比较区间 [i,j] 的
        // i-1 和 j 两处的前缀和是否相同
        // 本题的前缀和表示为: 前缀中对于0记为-1, 对于1 记为1
        // 记录最后的总和,表示为前缀和
        // 其实就是记录0和1的个数之差,如果两段前缀和的个数之差相同
        // 那么它们之间的那个区间就是0和1数量相同

        // 表示当前的前缀和
        int cur = 0;
        // 最终结果
        int res = 0;
        // 记录已经出现过的前缀和以及所在的索引
        // 对于相同的前缀和只记录最早的一个,从而形成更长的区间
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化一个没有任何元素的前缀和,长度为0, 索引记为-1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur--;
            } else {
                cur++;
            }

            if (map.containsKey(cur)) {
                res = Math.max(res, i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }

        return res;

    }
}
// @lc code=end

