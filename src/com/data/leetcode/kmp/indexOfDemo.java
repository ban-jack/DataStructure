package com.data.leetcode.kmp;

import com.data.test.Solution;

/*
28. 实现 strStr()
实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

示例 1：
输入：haystack = "hello", needle = "ll"
输出：2

示例 2：
输入：haystack = "aaaaa", needle = "bba"
输出：-1

示例 3：
输入：haystack = "", needle = ""
输出：0


提示：
0 <= haystack.length, needle.length <= 5 * 104
haystack 和 needle 仅由小写英文字符组成

https://leetcode-cn.com/problems/implement-strstr/
 */
public class indexOfDemo {
    public static void main(String[] args) {
        String s = "sss";
        String s1 = "s";
        int i = new indexOfDemo().strStr1(s,s1);
//        System.out.println(s.replace(s1,"0"));
        System.out.println(i);

    }

    // KMP算法 了解原理
//    public int strStr(String haystack, String needle) {
//
//    }

    // 暴力解法
    public int strStr2(String haystack, String needle) {
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();

        int len1 = haystack.length();
        int len2 = needle.length();

        int index1 = 0; // 索引指向s1
        int index2 = 0; // 索引指向s2
        while (index1 < len1 && index2 < len2){ //保证匹配时不越界
            if(s1[index1] == s2[index2]){ //匹配成功
                index1++;
                index2++;
            }else{ // 没有匹配成功
                index1 = index1 - (index2 -1);
                index2 = 0;
            }
        }
        // 判断是否匹配成功
        if(index2 == len2){
           return  index1 - index2;
        }else {
            return -1;
        }

    }

    // 自己的解法
    public int strStr1(String haystack, String needle) {
        if (haystack.length()==0&&needle.length()!=0){
            return -1;
        }
        if (haystack.length()==0||needle.length()==0){
            return 0;
        }
        String restr = haystack.replace(needle, "0");
        int length = restr.length();
        char[] chars = restr.toCharArray();
        int res = -1;
        for (int i = 0; i < length; i++){
            if(chars[i]=='0'){
                res = i;
                break;
            }

        }
        return res;
    }
}
