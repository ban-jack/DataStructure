package com.data.test;
import com.data.leetcode.linkedlist.ListNode;
import jdk.nashorn.internal.objects.NativeDate;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{2,1};
        int[] nums = new int[]{3,2,1,5,4,3,1};
        new Solution().nextPermutation(nums);
        for (int n: nums) {
            System.out.print(n+" ");
        }
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i>=0){
            int j = length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }

        res(nums,i+1, length);
    }

    public void swap(int[] nums, int i, int j){
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    public void res(int[] nums, int j, int len){
        for (int m = j, n = len -1; m < n; m++,n--){
            swap(nums,m,n);
        }
    }



}





