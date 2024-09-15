package _15_linkedlist;
//this code is kept in leetcode solution format
//if want to run locally then List creation will take place.
public class InterviewQuestions {

    //https://leetcode.com/problems/linked-list-cycle/
    //Amazon, Microsoft
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    //https://leetcode.com/problems/happy-number/description/
    //Google
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    // Google, Microsoft, Facebook: https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

    // google, amazon, facebook, microsoft: https://leetcode.com/problems/reverse-nodes-in-k-group/
    // Helper method to get the length of the linked list
    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // If k is less than or equal to 1 or head is null, no reversal is needed
        if (k <= 1 || head == null) {
            return head;
        }

        // Calculate the total length of the list
        int length = getLength(head);

        // Initialize pointers
        ListNode current = head;
        ListNode prevGroupEnd = null;
        ListNode newHead = null;

        // Process the list in chunks of k
        while (length >= k) {
            // Mark the start of the current group to be reversed
            ListNode groupStart = current;
            ListNode prev = null;
            ListNode next = null;

            // Reverse the k nodes in the current group
            for (int i = 0; i < k; i++) {
                next = current.next; // Save next node
                current.next = prev; // Reverse the link
                prev = current;      // Move prev to current node
                current = next;      // Move to next node
            }

            // Connect the previous part of the list to the reversed group
            if (prevGroupEnd != null) {
                prevGroupEnd.next = prev;
            } else {
                // This is the first group being reversed
                newHead = prev;
            }

            // Connect the end of the reversed group to the next part of the list
            groupStart.next = current;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;

            // Reduce the remaining length
            length -= k;
        }

        return newHead != null ? newHead : head;
    }

    // https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            // skip the k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    // linkedin, google, facebook, microsoft, amazon, apple
    //    https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }

    // https://leetcode.com/problems/reorder-list/
    // Google, Facebook
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}
