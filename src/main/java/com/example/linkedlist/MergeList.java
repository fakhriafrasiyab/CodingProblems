package com.example.linkedlist;

// Use a dummy head and a current pointer to build a new list.
// Compare the current nodes of both lists, attach the smaller one to the new list,
// and move the pointer of that list forward. Continue until one list is exhausted,
// then attach the remainder of the other list

// We return dummy.next because dummy is not a real part of the list; it's just a placeholder.
// The real merged list starts from dummy.next.

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


}

public class MergeList {

    public static ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1!=null && l2!=null){
            if (l1.val < l2.val) {
                tail = l1;
                l1 = l1.next;
            } else {
                tail = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }
}
