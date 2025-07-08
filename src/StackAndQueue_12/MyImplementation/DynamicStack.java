package src.StackAndQueue_12.MyImplementation;

public class DynamicStack extends CustomStack {
    public DynamicStack(){
        super(); //It will call parent class constructor which has no arg like this
        //It will call CustomStack()
    }

    public DynamicStack(int size){
        super(size); //It will call parent class constructor which has arg like this
        //It will call CustomStack(int size)
    }


    @Override
    public boolean push(int item) {
        //this takes care of it being full
        if (this.isFull()){
            //double the size
            int[] temp = new int[data.length*2];
            //copy all previous items in new array
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[i];
            }
            data=temp;
        }

        //at this point we know that array is not full
        //insert item
        return super.push(item);
    }
}
