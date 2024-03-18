/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int n1 = ver1.length;
        int n2 = ver2.length;

        int i1 = 0;
        int i2 = 0;

        while (i1 < n1 || i2 < n2) {
            int a = 0;
            int b = 0;
            if (i1 < n1) {
                a = Integer.valueOf(ver1[i1]);
                i1++;
            }
            if (i2 < n2) {
                b = Integer.valueOf(ver2[i2]);
                i2++;
            }
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
        }

        return 0;

    }
}
// @lc code=end

