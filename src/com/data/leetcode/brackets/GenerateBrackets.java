package com.data.leetcode.brackets;
/*
https://leetcode-cn.com/problems/generate-parentheses/

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
有效括号组合需满足：左括号必须以正确的顺序闭合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]


示例 2：
输入：n = 1
输出：["()"]
 
提示：
1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateBrackets {
    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParenthesis(3);
        for (String s:strings) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);
        return res;
    }

    //count1统计 “(”  的个数，count2统计 “)” 的个数
    public static void generate(List<String> res , String ans, int count1, int count2, int n){

        if(count1 > n || count2 > n) return;

        if(count1 == n && count2 == n)  res.add(ans);


        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);

        }
    }

}
