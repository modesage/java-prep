package _16_stacks_n_queues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue(5);
        CircularQueue queue = new CircularQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(6);
        queue.display();
    }
}
