package com.data.leetcode.search;

/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]

提示：
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109

https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

 */
public class findElementInArrayDemo {
    // 优质解法
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
    // 自己的解法
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
