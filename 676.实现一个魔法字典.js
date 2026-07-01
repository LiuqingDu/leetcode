/*
 * @lc app=leetcode.cn id=676 lang=javascript
 *
 * [676] 实现一个魔法字典
 */

// @lc code=start

var MagicDictionary = function() {
    this.dict = [];
};

/** 
 * @param {string[]} dictionary
 * @return {void}
 */
MagicDictionary.prototype.buildDict = function(dictionary) {
    this.dict = dictionary;
};

/** 
 * @param {string} searchWord
 * @return {boolean}
 */
MagicDictionary.prototype.search = function(searchWord) {

    for (let word of this.dict) {

        // 长度不同，不可能只改一个字符
        if (word.length !== searchWord.length) {
            continue;
        }

        let diff = 0;

        for (let i = 0; i < word.length; i++) {
            if (word[i] !== searchWord[i]) {
                diff++;
                if (diff > 1) {
                    break;
                }
            }
        }

        if (diff === 1) {
            return true;
        }
    }

    return false;
};

/** 
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = new MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */
// @lc code=end

