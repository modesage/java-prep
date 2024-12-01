package _16_stacks_n_queues;

import java.util.*;

public class InBuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        Queue<Integer> queue = new LinkedList<>();

        queue.add(5);
        queue.add(4);
        queue.add(3);

        System.out.println(queue);
//        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue);


        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(1);
        deque.addLast(2);
        deque.addLast(3);

        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque);
    }
}
