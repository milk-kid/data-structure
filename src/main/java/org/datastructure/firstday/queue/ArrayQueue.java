package org.datastructure.firstday.queue;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class ArrayQueue implements IQueue {

    int front = -1;
    int rear = -1;
    int maxSize = 3;
    int arr[] = new int[maxSize];

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int element) {
        if (isFull()) {
            throw new SysException(ExceptionEnum.ELEMENT_FULL);
        }
        rear++;
        arr[rear] = element;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int showHead() {

        if (isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        return arr[front + 1];
    }


}