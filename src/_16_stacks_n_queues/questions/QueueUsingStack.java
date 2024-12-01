package _16_stacks_n_queues.questions;

//leetcode
//232. Implement Queue using Stacks

import java.util.Stack;

//this implementation is insertion efficient in constant time O(1)
//removal and peek is in linear time O(N)
public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int removed = second.pop();

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int peeked = second.peek();

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

//this implementation is removal and peek efficient in constant time O(1)
//insertion is in linear time O(N)
/*
public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        first.push(x);

        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int pop() {
        return first.pop();
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
*/
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */