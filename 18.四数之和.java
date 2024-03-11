/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    // 有个测试用例四数之和溢出，改为long
                    long sum = (long)nums[a] + (long)nums[b] + (long)nums[c] + (long)nums[d];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        do {
                            c++;
                        } while (c < d && nums[c] == nums[c - 1]);
                        do {
                            d--;
                        } while (c < d && nums[d] == nums[d + 1]);
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

