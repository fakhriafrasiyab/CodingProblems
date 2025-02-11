package com.example.newChapterInLife;

public class AddTwoNumbers {

    public static ListNode returnNewList(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);


            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " -> ");
            list = list.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = returnNewList(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8 -> null

        test();
    }

    public static void test() {
        int test = 102;
        int x1 = test / 10;// 102/10 = 10
        int x2 = test % 10;// 102%10 = 2


        System.out.println(x1);
        System.out.println(x2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}