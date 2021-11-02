package com.data.leetcode.linkedlist;
/*
反转链表

示例1
输入：{1,2,3}
返回值：{3,2,1}

示例2
输入：{}
返回值：{}
说明：空链表则输出空
 */
public class reserveListDemo {
    public ListNode ReverseList(ListNode head) {
        ListNode curhead = head;
        if(curhead == null || curhead.next == null){ // 排除 {} 和 {1} 的情况
            return head;
        }
        ListNode p =new ListNode(-1); // 创建一个新链表
        ListNode temp = p;
        ListNode next;
        while(head != null){
            next = head.next;// 重点 需要暂时保存当前节点的下一个节点，因为后面需要使用
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return p.next;
    }
}
