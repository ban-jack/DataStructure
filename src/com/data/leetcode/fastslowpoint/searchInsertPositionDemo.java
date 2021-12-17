package com.data.leetcode.fastslowpoint;
/*
35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。

示例 1:
输入: nums = [1,3,5,6], target = 5
输出: 2

示例 2:
输入: nums = [1,3,5,6], target = 2
输出: 1

示例 3:
输入: nums = [1,3,5,6], target = 7
输出: 4

示例 4:
输入: nums = [1,3,5,6], target = 0
输出: 0

示例 5:
输入: nums = [1], target = 0
输出: 0


提示:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为无重复元素的升序排列数组
-104 <= target <= 104

https://leetcode-cn.com/problems/search-insert-position/
 */
public class searchInsertPositionDemo {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(target <= nums[0]){
            return 0;
        }
        if(target > nums[length -1]){
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
