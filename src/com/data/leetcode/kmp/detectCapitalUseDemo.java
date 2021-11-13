package com.data.leetcode.kmp;
/*
520. 检测大写字母
我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如 "USA" 。
单词中所有字母都不是大写，比如 "leetcode" 。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。

给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。

示例 1：
输入：word = "USA"
输出：true

示例 2：
输入：word = "FlaG"
输出：false
https://leetcode-cn.com/problems/detect-capital/
 */
public class detectCapitalUseDemo {
    // 解法三 巧妙
    public boolean detectCapitalUse2(String word) {
        // 第二个字母开始后面全部为小写，就不用管首字母是否为大写了
        return word.equals(word.toUpperCase())||word.substring(1).equals(word.substring(1).toLowerCase());
    }
    //解法二 正则
    public boolean detectCapitalUse1(String word) {
        return word.matches("[A-Z]+$|^[A-Z][a-z]+$|[a-z]+$");// String类的matches方法
    }
    //解法一 分类讨论
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (length == 1){
            return true;
        }

        char[] chars = word.toCharArray();
        char w = chars[0];
        char w1 = chars[1];


        if( w >= 97 && w <= 122){
            int i = 1;
            while(i < length){
                if(chars[i] < 97 || chars[i] > 122){
                    return false;
                }
                i++;
            }
        }else if (w >= 65 && w <= 90 && w1 >= 65 && w1 <= 90 ){
            int i = 2;
            while(i < length){
                if(chars[i] < 65 || chars[i] > 90){
                    return false;
                }
                i++;
            }
        }else if (w >= 65 && w <= 90 && w1 >= 97 && w1 <= 122 ){
            int i = 2;
            while(i < length){
                if(chars[i] < 97 || chars[i] > 122){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
