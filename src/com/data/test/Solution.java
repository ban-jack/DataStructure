package com.data.test;
import com.data.leetcode.linkedlist.ListNode;
import jdk.nashorn.internal.objects.NativeDate;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,7,9,2};
//        int[] nums = new int[]{1,2};
        int target = 11;
        int search = new Solution().search(nums, target);
        System.out.println(search);

    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        int first = nums[0];
        if (length < 2){
            if (first == target){
                return 0;
            }else {
                return -1;
            }
        }
        if (target == nums[length -1]){
            return length - 1;
        }
        int searchpoint = searchPoint(nums,length);
        int left = 0;
        int right = nums.length - 1;
        if (first == target) {
            return  0;
        } else if (target == nums[searchpoint]){
            return searchpoint;
        } else if (first > target && target > nums[searchpoint]){
            left = searchpoint;
        } else if (first < target && target < nums[searchpoint -1]){
            right = searchpoint - 1;
        }else if(target == nums[searchpoint - 1]){
            return searchpoint - 1;
        }else {
            return -1;
        }
        while (true) {
            int mid = left + (right + 1 - left) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid;
            } else if (nums[mid] < target){
                left = mid;
            }
            if (right + 1 - left <= 2){
                return -1;
            }

        }

    }
    public int searchPoint(int[] nums,int length){
        int first = nums[0];
        int left = 0;
        int right = length - 1;
        while (true) {
            int mid = left + (right + 1 - left) / 2;
            if (nums[mid] > first){
                left = mid;
            }else if (nums[mid] < first){
                right = mid;
            }
            if (right + 1 - left <= 2){
                return right; // 找到旋转的下标点
            }
        }
    }


}





