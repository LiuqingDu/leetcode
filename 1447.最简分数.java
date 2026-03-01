/*
 * @lc app=leetcode.cn id=1447 lang=java
 *
 * [1447] 最简分数
 */

// @lc code=start
class Solution {
    public List<String> simplifiedFractions(int n) {
        
        List<String> res = new ArrayList<>();

        for(int b = 2; b <= n; b++) {        // 分母
            for(int a = 1; a < b; a++) {     // 分子
                if(gcd(a, b) == 1) {
                    res.add(a + "/" + b);
                }
            }
        }

        return res;
    }

    // 最大公约数
    private int gcd(int a, int b) {
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
// @lc code=end

