package src.Top150.T7_Stack;

class MinStack {

    int[] arr;
    int top;
    int min;
    int size;

    public MinStack() {
        arr=new int[10];
        top=-1;
        min=top;
        size=0;
    }
    
    public void push(int value) {
        if (size==arr.length){
            int[] temp=new int[arr.length*2];
            for (int i = 0; i < arr.length; i++) {
                temp[i]=arr[i];
            }
            arr=temp;
        }
        arr[top+1]=value;
        top++;
        size++;
        if (value>arr[min]) min=top;
    }


    public void pop() {
        if (size>0) top--;
        size--;
        if (top+1==min){

        }
    }
    
    public int top() {
        
    }
    
    public int getMin() {
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */