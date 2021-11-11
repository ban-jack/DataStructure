package com.data.test;
import com.data.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        int i = new Solution().threeSumClosest(nums, target);
        System.out.println(i);

    }
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
