package easyLeet;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
       ListNode listNode1 = new ListNode(1);
       ListNode listNode2 = new ListNode(2, listNode1);
       ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNode5 = new ListNode(5, listNode4);
       System.out.println(listNode5);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    public static ListNode reverseList(ListNode head) {
        ListNode reversedList = new ListNode();
        if (head == null) return null;
        else {
            reversedList = head;
            reverseList(reversedList);
        }
        return reversedList;
    }
}