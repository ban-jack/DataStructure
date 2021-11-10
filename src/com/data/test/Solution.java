package com.data.test;
import com.data.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        int[] nums = new int[]{-1,0,1,2,-1,-2,-3,3,4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        for (List list:lists){
            for (Object i:list){
                System.out.print(i+"");
            }
            System.out.println("============");
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++){
            for (int j = i+1; j < length; j++){
                int n = -(i+j);
                for(int k = j + 1; k < length; k++){
                    List<Integer> list = new ArrayList<>();
                    if(n == k){
                        break;
                    }
                    list.add(i);

                }
            }
        }
        return lists;
    }
}
