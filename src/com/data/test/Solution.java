package com.data.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public void generate(List<String> res, String str, int left, int right, int n) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            res.add(str);
        }
        generate(res, str + "(", left, right, n);
        generate(res, str + ")", left, right, n);
    }

}
