package com.data.leetcode.search;
/*
33. 搜索旋转排序数组
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1


提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4

https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class rotatedSortedArrayDemo {

    /*
    官方的解法
    链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
     */
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }


    // 自己的解法
    public int search1(int[] nums, int target) {
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
