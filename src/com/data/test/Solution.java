package com.data.test;
import com.data.leetcode.linkedlist.ListNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public static void main(String args[]) {
        String word = "NBA";
        boolean b = new Solution().detectCapitalUse(word);
        System.out.println(b);
    }

    //由26个大写英文字母组成的字符串：^[A-Z]+$
    //由26个小写英文字母组成的字符串：^[a-z]+$
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
