/*
 * @lc app=leetcode.cn id=433 lang=javascript
 *
 * [433] 最小基因变化
 */

// @lc code=start
/**
 * @param {string} startGene
 * @param {string} endGene
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(startGene, endGene, bank) {
    const cnt = new Set();
    const visited = new Set();
    const keys = ['A', 'C', 'G', 'T'];
    for (const w of bank) {
        cnt.add(w);
    }
    if (startGene === endGene) {
        return 0;
    }
    if (!cnt.has(endGene)) {
        return -1;
    }
    const queue = [startGene];
    visited.add(startGene);
    let step = 1;
    while (queue.length) {
        const sz = queue.length;
        for (let i = 0; i < sz; i++) {
            const curr = queue.shift();
            for (let j = 0; j < 8; j++) {
                for (let k = 0; k < 4; k++) {
                    if (keys[k] !== curr[j]) {
                        const sb = [...curr];
                        sb[j] = keys[k];
                        const next = sb.join('');
                        if (!visited.has(next) && cnt.has(next)) {
                            if (next === endGene) {
                                return step;
                            }
                            queue.push(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        step++;
    }
    return -1;
};
// @lc code=end

