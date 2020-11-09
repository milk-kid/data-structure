package org.datastructure.firstday.queue;

import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {

        CircleArrayQueue queue = new CircleArrayQueue(4);
//        IQueue queue = new ArrayQueue();

        testQueue(queue);
    }

    private static void testQueue(IQueue queue) {
        boolean loop = true;
        while (loop) {

            Scanner scanner = new Scanner(System.in);
            char nextByte = scanner.next().charAt(0);
            switch (nextByte) {
                case 'a':
                    try {
                        queue.addQueue(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int n = queue.getQueue();
                        System.out.println(n);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(queue.showHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("退出队列！");

            }

        }
    }

}
