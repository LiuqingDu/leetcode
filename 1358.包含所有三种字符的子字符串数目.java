/*
 * @lc app=leetcode.cn id=1358 lang=java
 *
 * [1358] 包含所有三种字符的子字符串数目
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        
        int len = s.length();
        int ans = 0;
        int[][] pre = new int[3][len + 1];
        
        pre[0][0] = pre[1][0] = pre[2][0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                pre[j][i + 1] = pre[j][i];
            }
            pre[s.charAt(i) - 'a'][i + 1]++;
        }
        
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len, pos = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (pre[0][mid] - pre[0][i] > 0 && 
                    pre[1][mid] - pre[1][i] > 0 && 
                    pre[2][mid] - pre[2][i] > 0) {
                    right = mid - 1;
                    pos = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            if (pos != -1) {
                ans += len - pos + 1;
            }
        }
        
        return ans;

    }
}
// @lc code=end

