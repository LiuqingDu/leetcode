/*
 * @lc app=leetcode.cn id=718 lang=javascript
 *
 * [718] 最长重复子数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findLength = function(nums1, nums2) {
    /**
     * 
     * dp
     * 
     *  */
    // let m = nums1.length, n = nums2.length;
    // let dp = Array.from(new Array(m + 1), () => new Array(n + 1).fill(0));

    // let res = 0;
    // for (let i = m - 1; i >= 0; i--) {
    //     for (let j = n - 1; j >= 0; j--) {
    //         dp[i][j] = nums1[i] === nums2[j] ? dp[i+1][j+1] + 1 : 0;
    //         res = Math.max(res, dp[i][j]);
    //     }
    // }
    // return res;


    /**
     * 
     * 滑动窗口
     * 
     */
    let findMax = function (A, B) {
        let m = A.length, n = B.length;
        let max = 0;

        for (let len = 1; len < m; len++) {
            max = Math.max(max, find(A, B, 0, n - len, len));
        }

        for (let j = n - m; j >= 0; j--) {
            max = Math.max(max, find(A, B, 0, j, m));
        }
        for (let len = m - 1; len > 0; len--) {
            max = Math.max(max, find(A, B, m - len, 0, len));
        }
        return max;
    };

    let find = function (A, B, i, j, len) {
        let max = 0, count = 0;
        for (let k = 0; k < len; k++) {
            if (A[i + k] === B[j + k]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    };
    
    return nums1.length <= nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
};
// @lc code=end

