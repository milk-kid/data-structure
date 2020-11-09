package org.datastructure.secondday.linkedlist;

import java.util.Enumeration;
import java.util.Stack;

public class SingleLinkedList {
    private HeroNode head = new HeroNode(1, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void addList(HeroNode newHero) {
        HeroNode curr = head;
        while (true) {
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        curr.next = newHero;
    }

    public void addByOrder(HeroNode newHero) {
        HeroNode curr = head;
        while (true) {
            if (curr.next == null) {
                curr.next = newHero;
                return;
            }
            if (curr.next.no > newHero.no) {
                newHero.next = curr.next;
                curr.next = newHero;
                return;
            }
            curr = curr.next;
        }
    }

    public void deleteList(int no) {
        if (head.next == null) return;
        HeroNode curr = head;
        boolean flag = false;
        while (true) {
            if (curr.next == null) {
                break;
            }
            if (curr.next.no == no) {
                flag = true;
                break;
            }
            curr = curr.next;
        }
        if (flag) {
            curr.next = curr.next.next;
        } else {
            System.out.println("没有此英雄");
        }
    }

    public void editList(HeroNode newHero) {
        if (head.next == null) return;
        HeroNode curr = head;
        boolean flag = false;
        while (true) {
            if (curr.next == null) {
                break;
            }
            if (curr.next.no == newHero.no) {
                flag = true;
                break;
            }
            curr = curr.next;
        }
        if (flag) {
            curr.next.no = newHero.no;
            curr.next.name = newHero.name;
            curr.next.nickName = newHero.nickName;

            /*newHero.next = curr.next.next;
            curr.next = newHero;*/
        } else {
            System.out.println("没有该英雄");
        }
    }

    public int listLength(HeroNode head) {

        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode curr = head;
        while (true) {
            if (curr.next == null) {
                break;
            }
            length++;
            curr = curr.next;
        }
        return length;
    }

    public HeroNode getHeroByLast(SingleLinkedList list, int no) {
        if (list.getHead().next == null)
            return null;
        int length = listLength(list.getHead());

        if (no <= 0 || no > length) {
            System.out.println("index =0 或 index 大于链表长度");
            return null;
        }

        HeroNode curr = list.getHead().next;
        for (int i = 0; i < length - no; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void showList() {
        if (head.next == null) return;
        HeroNode curr = head.next;
        while (true) {
            System.out.println(curr);
            if (curr.next == null) return;
            curr = curr.next;
        }
    }

    public void reverseList(HeroNode head) {
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

    public void reversePrint(SingleLinkedList linkedList){
        if (linkedList.getHead() == null) {
            return;
        }
        HeroNode curr = linkedList.getHead().next;
        Stack<HeroNode> nodes = new Stack<>();
        while(true){
            if(curr == null){
                break;
            }
            nodes.add(curr);
            curr = curr.next;
        }

      while(nodes.isEmpty()){
          System.out.println(nodes.pop());
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

