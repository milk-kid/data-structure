package org.datastructure.secondday.queue;

public class CircleArrayQueue implements IQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public void addQueue(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    @Override
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    @Override
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }

        for (int i = front; i < front + (rear + maxSize - front) % maxSize; i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    @Override
    public int showHead() {
        if(isEmpty())   {
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }
}
