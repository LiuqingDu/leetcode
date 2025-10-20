/*
 * @lc app=leetcode.cn id=2341 lang=java
 *
 * [2341] 数组能形成多少数对
 */

// @lc code=start
class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        int leftovers = 0;
        for (int count : map.values()) {
            pairs += count / 2;
            leftovers += count % 2;
        }

        return new int[]{pairs, leftovers};
    }
}
// @lc code=end

