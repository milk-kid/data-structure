package org.datastructure.firstday.stack;

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

    }
}

class ArrayStack {
    int maxSize;
    int top = -1;
    int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void showStack(){
        for (int i = top; i >=0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

    public void push(int element) {
        if (isFull()) {
            throw new SysException(ExceptionEnum.ELEMENT_FULL);
        }
        top++;
        stack[top] = element;
    }

    public int pop() {
        int result = stack[top];
        top--;
        return result;
    }
}

