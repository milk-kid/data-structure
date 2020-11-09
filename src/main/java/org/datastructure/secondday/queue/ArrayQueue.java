package org.datastructure.secondday.queue;

public class ArrayQueue implements IQueue{
    int front;
    int rear;
    int[] arr;
    private int maxSize;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear == maxSize;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int i){
        if(isFull()){
            throw new RuntimeException("队列已满!");
        }

        arr[rear] = i;
        rear = rear+1;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front++];
    }

    public void showQueue(){
        for (int i = front; i < rear; i++) {
            System.out.printf("arr[%d] = %d\n",i, arr[i]);
        }
    }

    public int showHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front+1];
    }
}
