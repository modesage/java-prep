package _16_stacks_n_queues;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super(); //it will call CustomStack()
    }

    public DynamicStack(int size){
        super(size); //it will call CustomStack(size)
    }

    @Override
    public boolean push(int item) throws StackException {
        //this takes care of it being full
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];

            //copy all the previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        //at this point we know that array is ont full
        //insert item
        return super.push(item);
    }
}
