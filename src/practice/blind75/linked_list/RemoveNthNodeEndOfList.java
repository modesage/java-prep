package practice.blind75.linked_list;

public class RemoveNthNodeEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //init 2 pointers
        ListNode slow = dummy;
        ListNode fast = dummy;
        //move fast n+1 steps ahead (so slow ends up just before the node to remove)
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        //move both pointers until fast reaches the end
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //remove the target node
        slow.next = slow.next.next;
        //new head
        return dummy.next;
    }
}
