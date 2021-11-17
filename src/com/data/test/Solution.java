package com.data.test;
import com.data.leetcode.linkedlist.ListNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> lists = new Solution().fourSum(nums, target);
        for (List list:lists) {
            for (Object l:list) {
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i + 1; j < length; j++){

                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int aim = (target - nums[i] - nums[j]);
                int n = length - 1; // 每当前两个数的和发生改动需要重置 n
                for (int m = j + 1; m < length; m++){

                    if(m > j + 1 && nums[m] == nums[m-1]){
                        continue;
                    }

                    while (n > m && nums[n] + nums[m] > aim){
                        n--;
                    }

                    if (n == m){
                        break;
                    }

                    if(nums[n] + nums[m] + nums[j] + nums[i] == target){

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        lists.add(list);

                    }
                }

            }
        }
        return lists;

    }

}