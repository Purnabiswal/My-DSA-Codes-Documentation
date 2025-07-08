package src.LinkedList11.Questions;

public class LC_83_RemoveDuplicates {
    public static void main(String[] args) {
        LinkList list=new LinkList();
        LinkList list2=new LinkList();

//        list.insertFirst(3);
//        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(2);
        list.insertFirst(1);

        list2.insertFirst(9);
        list2.insertFirst(7);
        list2.insertFirst(5);
        list2.insertFirst(4);
        list2.insertFirst(3);
        list2.insertFirst(1);

        list.display();
    }

}

