package com.data.leetcode.scan;

/*
31. 下一个排列

实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]

示例 4：
输入：nums = [1]
输出：[1]

https://leetcode-cn.com/problems/next-permutation/
 */
public class nextArrangeDemo {

/*
    解题思路：两边扫描
    1,5,8,4,7,6,5,3,1
    第一步先找到非降序的数a[i](从后往前找）：4
    第二部找到比a[i]大的数(从后往前找）:5
    然后交换：  1,5,8,5,7,6,4,3,1
    第三部找将a[i]后面的数列反转： 1,5,8,5,1,3,4,6,7

 */
    public void nextPermutation(int[] nums) {
    int length = nums.length;
    int i = length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]){
        i--;//找到非降序的数
    }
    if (i >= 0){
        int j = length - 1;
        while (j >= 0 && nums[i] >= nums[j]){
            j--; //找到比非降序数大的数
        }
        // 交换
        swap(nums, i, j);
    }

    //降序
    reverse(nums,i + 1, length);
}

    public void swap(int[] nums, int i, int j){
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int len){
        for (int m = i, n = len - 1; m < n; m++,n--){
/*            int temp = 0;
            temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;*/
            swap(nums,m,n);
        }
    }
}
