/*
 * @lc app=leetcode.cn id=208 lang=javascript
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

var Trie = function() {

    this.end = false;
    this.children = Array(26);
};

/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {

    let node = this;
    for (let c of word.split("")) {
        let ind = c.charCodeAt(0) - 'a'.charCodeAt(0);
        if (!node.children[ind]) {
            node.children[ind] = new Trie();
        }
        node = node.children[ind];
    }
    node.end = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {

    let node = this;
    for (let c of word.split("")) {
        let ind = c.charCodeAt(0) - 'a'.charCodeAt(0);
        if (!node.children[ind]) {
            return false;
        }
        node = node.children[ind];
    }
    return node.end;

};

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {

    let node = this;
    for (let c of prefix.split("")) {
        let ind = c.charCodeAt(0) - 'a'.charCodeAt(0);
        if (!node.children[ind]) {
            return false;
        }
        node = node.children[ind];
    }
    return true;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
// @lc code=end

