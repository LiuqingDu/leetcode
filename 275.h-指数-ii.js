/*
 * @lc app=leetcode.cn id=275 lang=javascript
 *
 * [275] H 指数 II
 */

// @lc code=start
/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {

    let n = citations.length;
    let left = 0;
    let right = n;
    while (left < right) {
        let mid = Math.floor((left + right + 1) / 2);
        // mid 表示假设最终的h等于mid。也就是说
        // 如果右边有mid篇论文的引用大于mid，那么mid应当在右半边
        // 右边往左数第mid篇论文的引用就是citations[n - mid]
        if (citations[n - mid] >= mid) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }

    return left;

};
// @lc code=end

