package com.data.test;
import com.data.leetcode.linkedlist.ListNode;
import jdk.nashorn.internal.objects.NativeDate;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,7,7,10};
//        int[] nums = new int[]{1,2};
        int target = 7;
        int[] ints = new Solution().searchRange1(nums, target);
        System.out.println(Arrays.toString(ints));

    }
    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }
    //leftOrRight为true找左边界 false找右边界
    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if(leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
             return res;
    }
    public int[] searchRange(int[] nums, int target) {

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int l = mid - 1;
                int r = mid + 1;
                while (l >= 0 && nums[l] == target){
                    l--;
                }
                while (r <= right && nums[r] == target){
                    r++;
                }
                if (l == mid - 1 && r == mid + 1){
                    return new int[]{mid, mid};
                }else if (l == mid - 1){
                    return new int[]{mid, r - 1};
                }else if (r == mid + 1){
                    return new int[]{l + 1, mid};
                }else {
                    return new int[]{l + 1, r - 1};
                }
            }
        }
        return new int[] {-1, -1};
    }

}





