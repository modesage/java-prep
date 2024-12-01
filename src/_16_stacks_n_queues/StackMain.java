package _16_stacks_n_queues;

public class StackMain {
    public static void main(String[] args) throws StackException {
//        CustomStack stack = new CustomStack(5);
        //what all access can you get = what type of access can you get
        DynamicStack stack = new DynamicStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
