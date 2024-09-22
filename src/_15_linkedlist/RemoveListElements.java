package _15_linkedlist;

public class RemoveListElements {
    public static void main(String[] args) {

    }
    static ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy; // Start with the dummy node

        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node by skipping it
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the new head, which is next to the dummy node
        return dummy.next;
    }
}
