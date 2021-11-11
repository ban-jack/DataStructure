package com.data.leetcode.fastslowpoint;

import java.util.Arrays;
/*
16. 最接近的三数之和
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。

示例 1：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

示例 2：
输入：nums = [0,0,0], target = 1
输出：0

https://leetcode-cn.com/problems/3sum-closest/
 */
public class threeSumClosestDemo {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 重点一 排序 -->
        int length = nums.length;
        int res = 10000000; // 设置一个特别大的值 方便比较
        for (int i = 0; i < length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) { // 重点二 保证和上一次枚举的数不相等
                continue;
            }
            int j = i + 1, k = length - 1; // 重点三 双指针 + 二分法的思想
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){ // 比较绝对值
                    res = sum;
                }
                if(sum > target){  // 如果和大于target k指针向左移动
                    int k0 = k - 1;
                    while (j < k0 && nums[k] == nums[k0]){
                        k0--;
                    }
                    k = k0;
                }
                if( sum < target){ // 如果和小于target j指针向右移动
                    int j0 = j + 1;
                    while (j0 < k && nums[j] == nums[j0]){
                        j0++;
                    }
                    j = j0;
                }
            }
        }
        return  res;
    }
}
