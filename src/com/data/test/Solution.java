package com.data.test;
import com.data.leetcode.linkedlist.ListNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {

    public static void main(String[] args) {
//        Integer a = 1000;
//        Integer b = 1000;
//        Integer c = 100;
//        Integer g = 100;
//        Integer d = new Integer(100);
//        Integer e = new Integer(100);
//        int f = 100;
//
//        System.out.println("a==b:"+(a == b));
//        System.out.println("c==d:"+(c == d));
//
//        System.out.println("c==f:"+(c == f));
//        System.out.println("d==e:"+(d == e));
//        System.out.println("c==g:"+(c == g));
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println("i == i2 = " + (i == i2)); // Integer会自动拆箱为int，所以为true
        System.out.println("i == i3 = " + (i == i3)); // true，理由同上
        Integer i4 = 127;// 编译时被翻译成：Integer i4 = Integer.valueOf(127);
        Integer i5 = 127;
        System.out.println("i4 == i5 = " + (i4 == i5));// true
        Integer i6 = 128;
        Integer i7 = 128;
        System.out.println("i6 == i7 = " + (i6 == i7));// false
        Integer i8 = new Integer(127);
        System.out.println("i5 == i8 = " + (i5 == i8)); // false
        Integer i9 = new Integer(128);
        Integer i10 = new Integer(128);
        System.out.println("i9 == i10 = " + (i9 == i10)); // false
    }


}


