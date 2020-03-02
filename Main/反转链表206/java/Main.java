
/*

反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


class Solution {
    //不需要思考的方法
    public ListNode reverseList(ListNode head) {
        //特殊处理空单向链表情况
        if (head == null) {
            return null;
        }


        List<ListNode> originList = new ArrayList<>();

        while (head != null) {
            originList.add(head);
            System.out.println("add node:" + head.val);
            head = head.next;
        }


        int size = originList.size();


        for (int i = size - 1; i >= 1; i--) {
            originList.get(i).next = originList.get(i - 1);
        }

        originList.get(0).next = null;


        return originList.get(size - 1);
    }


    //借助一个临时变量
    public ListNode reverseList2(ListNode head) {
//        while (){
//
//        }
//
//        ListNode next = head.next;
//        ListNode originNode = next.next;
//        next.next = head;




    }


}


//单链表内部类
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
