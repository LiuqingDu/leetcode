/*
 * @lc app=leetcode.cn id=3289 lang=java
 *
 * [3289] 数字小镇中的捣蛋鬼
 */

// @lc code=start
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 2) {
                res.add(x);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();

    }
}
// @lc code=end

