package org.datastructure.firstday.stack;


import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(5);

        stack.showStack();
        System.out.printf("top = %d\n", stack.pop());
        System.out.printf("top = %d\n", stack.pop());
        System.out.printf("top = %d\n", stack.pop());
        System.out.printf("top = %d\n", stack.pop());
        System.out.printf("top = %d\n", stack.pop());
//        System.out.printf("top = %d\n", stack.pop());
//        System.out.printf("top = %d\n", stack.pop());
    }
}

class LinkedListStack {
    Node head = new Node(0);
    int maxSize;

    LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public int stackSise() {
        if (head.next == null) {
            return 0;
        }
        Node temp = head.next;
        int count = 1;
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isFull() {
        return maxSize == stackSise();
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public int pop() {
        if(isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        int no = head.next.no;
        head.next = head.next.next;
        return no;
    }

    public void push(int no) {
        if(isFull()) throw new SysException(ExceptionEnum.ELEMENT_FULL);
        Node temp = head.next;
        head.next = new Node(no);
        head.next.next = temp;
    }

    public void showStack(){
        if(isEmpty()){
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        Node temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            System.out.println(temp.next.no);
            temp = temp.next;
        }
    }

}

class Node {
    int no;
    Node next;

    public Node(int no) {
        this.no = no;
    }
}