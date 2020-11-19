package org.datastructure.secondday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
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

class ArrayStack {
    int maxSize;
    int top = -1;
    int[] stack;

    public ArrayStack(int masSize) {
        this.maxSize = masSize;
        stack = new int[masSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == - 1;
    }

    public void push(int no) {
        if (isFull()) {
            throw new SysException(ExceptionEnum.ELEMENT_FULL);
        }
        top++;
        stack[top] = no;
    }

    public int pop() {
        if (isEmpty()) throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        int temp = stack[top];
        top--;
        return temp;
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }

    }
}