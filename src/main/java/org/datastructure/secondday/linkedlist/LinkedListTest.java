package org.datastructure.secondday.linkedlist;



public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(new HeroNode(3, "李逵", "黑旋风"));
        list.addByOrder(new HeroNode(2, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(1,"林冲","豹子头"));
        list.showList();
        list.deleteList(4);
        list.showList();

        list.editList(new HeroNode(1,"林冲","豹子头edit"));
        list.showList();

        System.out.println(list.listLength(list.getHead()));
        System.out.println(list.getHeroByLast(list, 1));

        list.showList();
        list.reverseList(list.getHead());
        System.out.println("------------------");
        list.showList();

        list.reversePrint(list);
    }
}
