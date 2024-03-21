/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        String[] numStrs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        if (numStrs[0].equals("0")) {
            return "0";
        }

        return String.join("", numStrs);

    }
}
// @lc code=end

