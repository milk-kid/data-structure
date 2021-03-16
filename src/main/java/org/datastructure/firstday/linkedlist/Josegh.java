package org.datastructure.firstday.linkedlist;

/**
 * 约瑟夫环一共分四步
 * todo 第一步：需要辅助指针helper指向环形列表最后节点，也就是要出圈的后一个元素，帮助小孩出圈，first指向要出圈的元素
 * TODO 第二步：小孩报数前先让helper，first移动k-1次 到预定位置startNo
 * todo 第三步：当小孩报数时helper和first指针同时移动 1
 * todo 第四步：这时first指向的节点就是要出圈的小孩节点  出圈 first= first.getNext();  helper.setNext(first)
 */
public class Josegh {


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

    /**
     * @param startNo  开始报数位置
     * @param countNum 表示数几个数
     * @param nums     小孩个数
     */
    public void countBoy(int startNo, int countNum, int nums) {

        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误，请重新输入");
            return;
        }

        //todo 第一步需要辅助指针helper指向环形列表最后节点，也就是要出圈的后一个元素，帮助小孩出圈，first指向要出圈的元素
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //TODO 第二步：小孩报数前先让helper，first移动k-1次 到预定位置startNo
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }
            //todo 第三步：当小孩报数时helper和first指针同时移动1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
                //todo 第四步：这时first指向的节点就是要出圈的小孩节点

                System.out.printf("小孩%d出圈\n", first.getNo());
                //这时将first指向的小孩出圈
                first = first.getNext();
                helper.setNext(first);
            }
        }
        System.out.printf("剩下的一个小孩%d\n",helper.getNo());
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
