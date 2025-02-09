/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 可以看出要优先把负数取反,变为正数
        // 且更小的负数优先
        // 当把所有负数都取反后,如果还有剩余次数
        // 此时数组内全都是非负数, 把最小的那个数字用掉所有剩余次数即可
        // 无论剩余次数是偶数还是奇数都不影响
        // 当然,可以优化一下,如果 k 是偶数,则无需再处理,偶数次可以翻转成当前同样的情况不变
        // 如果 k 是奇数,但存在 0,那么也可以只翻转 0
        // 所以只有当 k 为奇数且没有 0 的时候,才需要找到最小数,且把它翻转一次就可以了
        // 注意到数字的范围是[-100,100], 可以用一个数组来记录每个数字出现的次数
        // 这样就不需要预先排序了

        // 统计每个数出现次数,避免排序
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 把负数从小到大依次翻转
        // 直到用尽次数或者负数全都翻转了
        for (int i = -100; i < 0 && k > 0; i++) {
            if (freq.containsKey(i)) {
                int t = Math.min(freq.get(i), k);
                k -= t;
                freq.put(i, freq.get(i) - t);
                freq.put(-i, freq.getOrDefault(-i, 0) + t);
            }
        }

        // 此时只有非负数了
        // 如果还有次数,且次数是奇数,且不存在 0, 那么就需要找一个最小数,翻转一次
        if (k > 0 && k % 2 == 1 && !freq.containsKey(0)) {
            for (int i = 1; i <= 100; i++) {
                if (freq.containsKey(i)) {
                    freq.put(i, freq.get(i) - 1);
                    freq.put(-i, freq.getOrDefault(-i, 0) + 1);
                    break;
                }
            }
        }

        // 统计总和
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }
}
// @lc code=end

