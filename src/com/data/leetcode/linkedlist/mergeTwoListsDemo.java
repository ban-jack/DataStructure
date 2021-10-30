package com.data.leetcode.linkedlist;
/*
https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class mergeTwoListsDemo {
    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 注意空链表的情况
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newL= new ListNode(-1);//创建一个新链表
        ListNode head = newL; //遍历节点
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head=head.next;
        }
        //******************重点*************
        //合并后l1和l2最多还有一个没被合并
        //直接讲链表末尾指向未合并完的链表即可
        head.next = l1 == null ? l2:l1;

        return newL.next;
    }
}

