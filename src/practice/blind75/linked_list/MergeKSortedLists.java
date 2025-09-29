package practice.blind75.linked_list;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // min-heap to compare node values
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
        );

        // add the head of each non-null list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        // dummy head for result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // while heap is not empty, build the result list
        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();      // get the smallest node
            current.next = smallest;              // append to result
            current = current.next;               // move current

            if (smallest.next != null) {
                heap.offer(smallest.next);        // add next node from that list
            }
        }

        return dummy.next;
    }
}
