package com.data.leetcode.recursion;

import com.data.test.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例 2：
输入：digits = ""
输出：[]

示例 3：
输入：digits = "2"
输出：["a","b","c"]

提示：
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
public class letterCombinationsDemo {

    public static void main(String[] args) {
//        输入：digits = "23"
//        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        String d = "23";
        System.out.println(new letterCombinationsDemo().letterCombinations(d));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0 ){
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, map, new StringBuffer(), list);
        return list;

    }

    public void backtrack(String digits, int index, Map<Character,String> map, StringBuffer str, List<String> list){
        if (index == digits.length()){ // 当index的长度与输入数字长度相等时，输出结果，存储在list集合里面
            list.add(str.toString());
        } else {
            char key = digits.charAt(index);
            String letters = map.get(key);

            for (int i = 0; i < letters.length(); i++){
                char c = letters.charAt(i);
                str.append(c);
                backtrack(digits, index + 1, map, str, list); // 再次迭代 index 加1
                str.deleteCharAt(index); // 清空当前索引上的字符，进入下一次循环
            }
        }

    }
}
