/*
 * @lc app=leetcode.cn id=211 lang=javascript
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start

var TrieNode = function() {
    this.children = Array(26);
    this.end = false;
}

var WordDictionary = function() {

    this.root = new TrieNode();
};

/** 
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function(word) {

    let node = this.root;
    for (let c of word.split("")) {
        if (!node.children[c.charCodeAt(0) - "a".charCodeAt(0)]) {
            node.children[c.charCodeAt(0) - "a".charCodeAt(0)] = new TrieNode();
        }
        node = node.children[c.charCodeAt(0) - "a".charCodeAt(0)];
    }
    node.end = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
WordDictionary.prototype.search = function(word) {

    let dfs = function(node, chars, ind) {
        if (chars.length === ind) {
            return node.end;
        }

        if (chars[ind] !== ".") {
            if (!node.children[chars[ind].charCodeAt(0) - "a".charCodeAt(0)]) {
                return false;
            }
            return dfs(node.children[chars[ind].charCodeAt(0) - "a".charCodeAt(0)], chars, ind + 1);
        } else {
            for (let t of node.children) {
                if (t && dfs(t, chars, ind + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    return dfs(this.root, word.split(""), 0);
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
// @lc code=end

