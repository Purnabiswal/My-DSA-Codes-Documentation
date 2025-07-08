package src.StackAndQueue_12.MyImplementation;

public class StackMain {
    public static void main(String[] args) throws StackException {
//        CustomStack stack = new CustomStack(5);
//        stack.push(34);
//        stack.push(68);
//        stack.push(25);
//        stack.push(52);
//        stack.push(75);
//        stack.push(87); //this will cause stack full

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());


        CustomStack stack = new DynamicStack(5);
        stack.push(34);
        stack.push(68);
        stack.push(25);
        stack.push(52);
        stack.push(75);
        stack.push(87);

        CustomStack stack2 = new DynamicStack();
        stack2=stack;
        stack2.display();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());















//        int[] arr1={1,2,3};
//        int[] arr2=new int[1];
//        arr2=arr1;
////        System.out.println(arr1[0]);
//
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.print(arr2[i]);
//        }

    }
}
