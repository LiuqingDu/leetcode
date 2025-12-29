/*
 * @lc app=leetcode.cn id=2696 lang=javascript
 *
 * [2696] 删除子串后的字符串最小长度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minLength = function(s) {
    const st = new Array();
    for (const c of s) {
        st.push(c);
        let m = st.length;
        if (m >= 2 &&
            (st[m - 2] == 'A' && st[m - 1] == 'B' ||
            st[m - 2] == 'C' && st[m - 1] == 'D')) {
            st.pop();
            st.pop();
        }
    }
    return st.length;
};
// @lc code=end

