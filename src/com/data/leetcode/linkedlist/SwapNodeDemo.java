package com.data.leetcode.linkedlist;
/*
24. 两两交换链表中的节点

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNodeDemo {


    public ListNode swapPairs(ListNode head) {

        ListNode newH = new ListNode(-1);// 新建一张链表
        ListNode cur = head;
        ListNode cur1 = head;
        ListNode temp = newH;
        if(cur != null && cur.next==null){ //[1]
            return cur;
        }
        while(cur!=null){

            if(cur.next!=null){
                temp.next = cur.next;
                cur.next = cur.next.next;
                temp.next.next = cur;
                temp = cur;
            }
            cur = cur.next;
        }
        return newH.next;
    }
}
