package _16_stacks_n_queues;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item) throws StackException{
        if(isFull()){
            throw new StackException("The Stack is full!");
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot pop from an empty stack");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty stack");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length-1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }
}
