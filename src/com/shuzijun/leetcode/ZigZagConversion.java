package com.shuzijun.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int rowSize = (numRows - 1) * 2;
        char[] ss = s.toCharArray();
        int len = ss.length;
        int countRow = len / rowSize + 1;
        char[] newss = new char[countRow * rowSize];

        for (int i = 0; i < len; i++) {
            int thisRow = i / rowSize;
            int rowSerial = i % rowSize;

            if (rowSerial == 0) {
                newss[thisRow] = ss[i];
            } else if (rowSerial < numRows - 1) {
                newss[thisRow * 2 + countRow + (rowSerial - 1) * countRow * 2] = ss[i];
            } else if (rowSerial == numRows - 1) {
                newss[thisRow + countRow + (rowSerial - 1) * countRow * 2] = ss[i];
            } else {
                newss[(thisRow + 1) * 2 - 1 + countRow + ((numRows - rowSerial % numRows - 2) - 1) * countRow * 2] = ss[i];

            }
        }
        return String.valueOf(newss).replace("\u0000", "");

    }
}
