package com.data.leetcode.fastslowpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
18. 四数之和
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
请你找出并返回满足下述全部条件且不重复的四元组
[nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

示例 1：
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

示例 2：
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]

https://leetcode-cn.com/problems/4sum/
 */
public class FourSumDemo {

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
