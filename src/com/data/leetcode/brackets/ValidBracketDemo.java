package com.data.leetcode.brackets;

import java.util.Stack;

/*
https://leetcode-cn.com/problems/valid-parentheses/

20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。


示例 1：
输入：s = "()"
输出：true


示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([)]"
输出：false

示例 5：
输入：s = "{[]}"
输出：true
 */
public class ValidBracketDemo {
    // 法一
    public boolean isValid1(String s) {
        while(s.contains("()")||s.contains("[]")||s.contains("{}")){
            if(s.contains("()")){
                s=s.replace("()","");
            }
            if(s.contains("{}")){
                s=s.replace("{}","");
            }
            if(s.contains("[]")){
                s=s.replace("[]","");
            }
        }
        return s.length()==0;
    }

    // 法二
    //peek方法是返回栈顶的元素但不移除它
    public boolean isValid2(String s) {
        if(s.length()%2==0){     // 长度不是偶数的排除
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c=='('||c=='['||c=='{'){
                    stack.push(c);
                }
                else if(c==')'){
                    if(!stack.isEmpty()&&stack.peek()=='('){stack.pop();}
                    else{return false;}
                }
                else if(c=='}'){
                    if(!stack.isEmpty()&&stack.peek()=='{'){stack.pop();}
                    else{return false;}
                }
                else{
                    if(!stack.isEmpty()&&stack.peek()=='['){stack.pop();}
                    else{return false;}
                }
            }
            return stack.isEmpty();
        }
        return false;
    }
}
