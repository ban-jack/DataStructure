package com.data.leetcode.Fibonacci;


public class FibonacciDemo {
    /*斐波那契数列:0、1、1、2、3、5、8、13、21、34、……*/
    public static void main(String[] args) {
        System.out.println(Solution2(7));
    }

    // 求出斐波那契额数列的的第n项
    //法一
    public static int Solution1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return Solution1(n - 1) + Solution1(n - 2);
    }

    //法二
    public static int Solution2(int n) {
        if (n < 2) {
            return n;
        }

        int x = 0, y = 1, result = 0;
        for (int i = 1; i < n; i++) {//这里的n>=2
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }

    /*
    有一份数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
    */
    // 斐波那契额数列
    public static void Solution3() {
        double x = 2, y = 1, sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += x / y;
            x = x + y;
            y = x - y;
        }
        System.out.println(sum);
    }

}
