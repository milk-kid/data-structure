package org.datastructure.firstday.linkedlist;

public class Josegh {


    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBody(5);
        circleSingleLinkedList.showBoy();
    }
}

class CircleSingleLinkedList {

    private Boy first = null;

    public void addBody(int no) {
        if (no < 2) {
            System.out.println("小孩数不能小于2个");
            return;
        }

        Boy curBoy = null;
        for (int i = 1; i <= no; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("小孩为空！");
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("当前小孩编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}

class Boy {
    private int no;//编号
    private Boy next;//下一个body

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
