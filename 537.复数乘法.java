/*
 * @lc app=leetcode.cn id=537 lang=java
 *
 * [537] 复数乘法
 */

// @lc code=start
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // (a+bi)(c+di) = (ac-bd)+(bc+ad)i

        // 解析第一个复数
        int[] complex1 = parseComplex(num1);
        int a = complex1[0]; // num1 的实部
        int b = complex1[1]; // num1 的虚部

        // 解析第二个复数
        int[] complex2 = parseComplex(num2);
        int c = complex2[0]; // num2 的实部
        int d = complex2[1]; // num2 的虚部

        // 复数乘法公式
        int realPart = a * c - b * d; // 实部
        int imaginaryPart = a * d + b * c; // 虚部

        // 构造结果字符串
        return realPart + "+" + imaginaryPart + "i";
    }

    // 工具方法：解析复数字符串为 [实部, 虚部]
    private int[] parseComplex(String num) {
        String[] parts = num.split("\\+"); // 根据 '+' 分割
        int real = Integer.parseInt(parts[0]); // 实部
        int imaginary = Integer.parseInt(parts[1].replace("i", "")); // 去掉虚部的 'i'
        return new int[]{real, imaginary};
    }
}
// @lc code=end

