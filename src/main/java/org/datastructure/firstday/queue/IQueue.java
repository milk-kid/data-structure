package org.datastructure.firstday.queue;

public interface IQueue {
    boolean isFull();

    boolean isEmpty();

    void addQueue(int n);

    int getQueue();

    void showQueue();

    int showHead();
}
