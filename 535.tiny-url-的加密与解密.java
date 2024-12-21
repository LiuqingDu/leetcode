/*
 * @lc app=leetcode.cn id=535 lang=java
 *
 * [535] TinyURL 的加密与解密
 */

// @lc code=start
public class Codec {

    // 使用 HashMap 保存短 URL 和原始 URL 的映射
    private HashMap<String, String> map = new HashMap<>();
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6; // 短 URL 长度
    private Random random = new Random();

    // 生成随机字符串
    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(CHAR_SET.length());
            sb.append(CHAR_SET.charAt(index));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl;
        do {
            shortUrl = generateRandomString();
        } while (map.containsKey(shortUrl)); // 确保唯一性

        map.put(shortUrl, longUrl); // 将短 URL 和长 URL 映射
        return BASE_URL + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, ""); // 提取随机字符串部分
        return map.get(key); // 从 map 中查找并返回原始 URL
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end

