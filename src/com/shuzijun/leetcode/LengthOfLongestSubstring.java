package com.shuzijun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        Map<Character, Integer> strMap = new HashMap<Character, Integer>();
        char[] strs = s.toCharArray();
        for (int i = 0, j = -1, z = strs.length; i < z && z - j > len; i++) {
            if (strMap.containsKey(strs[i])) {
                j = Math.max(strMap.get(strs[i]), j);
            }
            strMap.put(strs[i], i);
            len = Math.max(len, i - j);

        }
        return len;
    }
}
