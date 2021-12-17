package com.data.test;
import com.data.leetcode.linkedlist.ListNode;
import jdk.nashorn.internal.objects.NativeDate;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    //-2147483648
    //-1
    // int 范围 -2147483648 - 2147483647
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 1;
        System.out.println(searchInsert(nums,target));

    }
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(target <= nums[0]){
            return 0;
        }
        if(target >= nums[length -1]){
            return length;
        }
        int i = length / 2;
        int fast = length - 1;
        int slow = 0;
        while (slow < fast){
             if(nums[i] == target){
                 return i;
             }else if(target < nums[i]){
                 fast = i;
             }else if(target > nums[i]){
                 slow = i;
             }
             i = (fast + 1 -slow) / 2 + slow;
             if(fast + 1 - slow == 2 ){
                 return slow + 1;
             }
        }
        return 0;
    }
}





