package practice.blind75.linked_list;
//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //dummy node to simplify handling the head
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        //attach the remaining part (only one of these will be non-null)
        if(list1 != null){
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next; //real head of the merged list
    }
}
