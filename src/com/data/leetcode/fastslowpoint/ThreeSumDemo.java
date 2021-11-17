package com.data.leetcode.fastslowpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]

https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSumDemo {
    public List<List<Integer>> threeSum(int[] nums) {
        // 重点一 排序 --> 减少重复
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        // 枚举第一个数 a
        for (int i = 0; i < length; i++){
            // 重点二  遇到和上一次枚举数相同的情况跳过 --> 减少重复
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            // 重点三 采用双指针的方法 首尾同时进行遍历 --> 减少时间复杂度
            int k = length - 1; // 每当i移动都需要重置k
            // 枚举第二个数 b
            for (int j = i + 1; j < length; j++){
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                // 同时枚举第三个数 c 需要保证 k指针 在 j指针 的左侧
                while( k > j && nums[j]+nums[k] > target){
                    k--;
                }
                // 当指针重合 随着 b 的增加 不会出现 满足 a+b+c=0 且 b<c 的 c 了
                if(k == j){
                    // 退出循环
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }
            }

        }
        return  lists;
    }
}
