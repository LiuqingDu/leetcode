/*
 * @lc app=leetcode.cn id=535 lang=javascript
 *
 * [535] TinyURL 的加密与解密
 */

// @lc code=start
/**
 * Encodes a URL to a shortened URL.
 *
 * @param {string} longUrl
 * @return {string}
 */
var encode = function(longUrl) {
    let shortUrl;
    do {
        shortUrl = generateRandomString();
    } while (map.has(shortUrl));

    map.set(shortUrl, longUrl);
    return baseUrl + shortUrl;
};

/**
 * Decodes a shortened URL to its original URL.
 *
 * @param {string} shortUrl
 * @return {string}
 */
var decode = function(shortUrl) {
    const key = shortUrl.replace(baseUrl, "");
    return map.get(key);
};

const charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
const shortUrlLength = 6;
const map = new Map();
const baseUrl = "http://tinyurl.com/";

var generateRandomString = function () {
    let result = "";
    for (let i = 0; i < shortUrlLength; i++) {
        const randomIndex = Math.floor(Math.random() * charSet.length);
        result += charSet[randomIndex];
    }
    return result;
}

/**
 * Your functions will be called as such:
 * decode(encode(url));
 */
// @lc code=end

