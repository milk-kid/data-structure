package org.datastructure.firstday.queue;


import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

/**
 * 1.首先明确front和rear的定义，front指向队列的头，rear指向队列最后一个元素的后一个位置
 * 2.环形队列需要知道队列满，队列空
 * 3.队列满的算法为：（rear+1）%maxSize == front 因为rear本身指向最后一个元素的后一个位置，所以rear+1预留一个位置
 * 4.队列空的算法为：rear == front
 */
public class CircleArrayQueue implements IQueue {
    int rear;
    int front;
    int maxSize;
    int arr[];

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void showQueue(){
        for (int i=front;i<front+(rear+maxSize-front)%maxSize;i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize , arr[i%maxSize]);
        }
    }

    public int showHead(){
        return arr[front];
    }

}
