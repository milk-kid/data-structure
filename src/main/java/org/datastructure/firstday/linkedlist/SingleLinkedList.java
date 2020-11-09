package org.datastructure.firstday.linkedlist;

import java.util.Stack;

public class SingleLinkedList {
    private HeroNode head = new HeroNode(1, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void addList(HeroNode hero) {
        HeroNode temp = head;
        if (temp == null) {
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = hero;
    }

    public void addByOrder(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = hero;
                return;
            }
            if (temp.next.no > hero.no) {
                hero.next = temp.next;
                temp.next = hero;
                return;
            }
            temp = temp.next;
        }

    }

    public void deleteList(int no) {
        HeroNode temp = head;
        if (temp.next == null) return;

        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (no == temp.next.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("该英雄不存在！");
        }
    }

    public void editList(HeroNode newHero) {
        HeroNode temp = head;
        if (temp.next == null) return;

        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == newHero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next.name = newHero.name;
            temp.next.nickName = newHero.nickName;
        } else {
            System.out.println("此英雄不存在！");
        }
    }

    public void showList() {
        if (head.next == null) return;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    public int listLength(HeroNode head) {
        if (head.next == null) return 0;
        HeroNode temp = head;
        int count = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            ++count;
            temp = temp.next;
        }
        return count;
    }

    public HeroNode getHeroByLast(SingleLinkedList list, int lastIndex) {
        if (list.getHead().next == null) {
            return null;
        }
        int length = list.listLength(list.getHead());
        if (lastIndex <= 0 || lastIndex > length) {
            return null;
        }

        HeroNode temp = head.next;
        for (int i = 0; i < length - lastIndex; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public void reverse(HeroNode head) {

        if (head.next == null||head.next.next ==null) {
            return;
        }

        HeroNode reverse = new HeroNode(0, "", "");
        //这里一定不要是直接赋值head，否则会将head与第一个元素reverse
        HeroNode curr = head.next;
        HeroNode next;
        while (curr!= null) {
            next = curr.next;
            curr.next = reverse.next;
            reverse.next = curr;
            curr = next;
        }

        head.next = reverse.next;
    }

    public void reversePrint(HeroNode head){
        if (head.next == null) {
            return;
        }
        HeroNode current = head.next;
        Stack stack = new Stack<HeroNode>();
        while(current!=null){
            stack.add(current);
            current = current.next;
        }


    }

}

class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}