/*
 * @lc app=leetcode.cn id=1169 lang=javascript
 *
 * [1169] 查询无效交易
 */

// @lc code=start
/**
 * @param {string[]} transactions
 * @return {string[]}
 */
var invalidTransactions = function(transactions) {
    const n = transactions.length;
    const parsed = [];
    const invalid = new Array(n).fill(false);

    // 1. 解析交易
    for (let i = 0; i < n; i++) {
        const [name, time, amount, city] = transactions[i].split(",");
        parsed.push({
            name,
            time: Number(time),
            amount: Number(amount),
            city,
            raw: transactions[i]
        });

        // 规则 1：金额超过 1000
        if (parsed[i].amount > 1000) {
            invalid[i] = true;
        }
    }

    // 2. 检查同名 + 不同城市 + 60 分钟内
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (
                parsed[i].name === parsed[j].name &&
                parsed[i].city !== parsed[j].city &&
                Math.abs(parsed[i].time - parsed[j].time) <= 60
            ) {
                invalid[i] = true;
                invalid[j] = true;
            }
        }
    }

    // 3. 收集无效交易
    const result = [];
    for (let i = 0; i < n; i++) {
        if (invalid[i]) {
            result.push(parsed[i].raw);
        }
    }

    return result;
};
// @lc code=end

