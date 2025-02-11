package com.example.newChapterInLife;

public class DetectionCycle {
    public static ListNode detectCycle(ListNode l1) {
        ListNode slow = l1, fast = l1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = l1;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        ListNode cycle = detectCycle(l1);
        printList(l1, cycle);

    }

    static void printList(ListNode l1, ListNode cycle) {
        ListNode temp = l1;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
            if(temp==cycle){
                System.out.print("(cycle starts at " + cycle.val + ")");
                break;
            }
        }
        System.out.println("null");
    }
}


