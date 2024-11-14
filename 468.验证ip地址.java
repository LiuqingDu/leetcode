/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(c -> c == '.').count() == 3) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.chars().filter(c -> c == ':').count() == 7) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private boolean isIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.charAt(0) == '0' && part.length() > 1) return false;
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        String[] parts = ip.split(":");
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c) && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) return false;
            }
        }
        return true;
    }
}
// @lc code=end

