/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    public int calPoints(String[] operations) {
        int[] arr = new int[1000];
        int ind = 0;
        for (String op: operations) {
            switch (op) {
                case "C":
                    ind--;
                    arr[ind] = 0;
                    break;
                case "D":
                    arr[ind] = arr[ind - 1] * 2;
                    ind++;
                    break;
                case "+":
                    arr[ind] = arr[ind - 1] + arr[ind - 2];
                    ind++;
                    break;
                default:
                    arr[ind] = Integer.parseInt(op);
                    ind++;
                    break;
            }
        }
        return Arrays.stream(arr).sum();
    }
}
// @lc code=end

