package com.data.leetcode.linkedlist;
/*
19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]

提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNodeDemo {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = getlength(head);
        ListNode temp = head;
        if(n == length){
            return temp.next;
        }
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            if(count == length-n-1){// 这里排除了 n==length（head = [1], n = 1）的情况
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            count++;
        }
// 优化
//        for(int i=0;i<length-n-1;i++){
//            cur=cur.next;
//        }
//        cur.next=cur.next.next;

        return head;

    }

    public int getlength(ListNode head){
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        System.out.println(count);
        return count;
    }
}
