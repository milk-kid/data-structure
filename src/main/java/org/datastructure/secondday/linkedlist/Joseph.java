package org.datastructure.secondday.linkedlist;

public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList {

    private Boy first = null;

    public void addBoy(int no) {
        if (no < 1) {
            System.out.println("小孩子数量不能低于1");
            return;
        }

        Boy currBoy = null;
        for (int i = 1; i <= no; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                currBoy = first;
            } else {
                currBoy.setNext(boy);
                boy.setNext(first);
                currBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("环形链表没有小孩，请先添加");
            return;
        }
        Boy currBoy = first;
        while (true) {
            System.out.printf("小孩%d报数\n", currBoy.getNo());
            if (currBoy.getNext() == first) {
                break;
            }
            currBoy = currBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo > nums || startNo < 1) {
            System.out.println("参数错误，请重新输入");
            return;
        }

        //todo 第一步：授权创建helper辅助指针，
        Boy helper = first;
        //todo 让helper指向链表最后一个节点，辅助小孩出圈
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //todo 第二步：让first/helper指针移动到startNo - 1 指定节点
        for (int i = 1; i <= startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //todo 第三步：让first/helper指针移动countNum - 1，此时first = 出圈小孩

        while (true) {
            if(helper == first){//此时只有一个小孩
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                helper =helper.getNext();
                first = first.getNext();
                System.out.printf("出圈小孩%d\n",first.getNo());
            }
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.printf("最后出圈小孩%d\n",helper.getNo());

    }
}

class Boy {
    private int No;
    private Boy next;

    public Boy(int no) {
        No = no;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}