package org.datastructure.secondday.stack;

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
    Node head = new Node(-1);
    int maxSize;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public int stackSize() {
        Node temp = head;
        int count = 0;
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
        return stackSize() == maxSize;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(int no) {
        if (isFull()) {
            throw new SysException(ExceptionEnum.ELEMENT_FULL);
        }
        if (head.next == null) {
            head.next = new Node(no);
        } else {
            Node temp = head.next;
            head.next = new Node(no);
            head.next.next = temp;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        Node temp = head.next;
        head.next = head.next.next;
        return temp.no;

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