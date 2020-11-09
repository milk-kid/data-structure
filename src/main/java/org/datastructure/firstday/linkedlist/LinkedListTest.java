package org.datastructure.firstday.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        HeroNode2 songjiang = new HeroNode2(2, "宋江", "及时雨");
        HeroNode2 likui = new HeroNode2(3,"李逵","黑旋风");
        HeroNode2 linchong = new HeroNode2(1,"林冲","豹子头");

        linkedList.addByOrder(songjiang);
        linkedList.addByOrder(likui);
        linkedList.addByOrder(linchong);

        linkedList.editList(new HeroNode(1,"松江","ahhah"));
        linkedList.showList();

        System.out.println(linkedList.listLength(linkedList.getHead()));

        System.out.println(linkedList.getHeroByLast(linkedList,2));

//        linkedList.reverse(linkedList.getHead());
        linkedList.showList();


    }
}
