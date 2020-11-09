package org.datastructure.secondday.linkedlist;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return this.head;
    }

    public void addList(HeroNode2 newHero) {
      HeroNode2 temp = head;
      while(true){
          if(temp.next ==null){
              break;
          }
          temp = temp.next;
      }
      temp.next = newHero;
      newHero.pre = temp;
    }

    public void addByOrder(HeroNode2 newHero) {
        HeroNode2 temp  = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no >newHero.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next= newHero;
            newHero.pre = temp;
        }else{
            newHero.next = temp.next;
            temp.next = newHero;
            newHero.pre = temp;
            newHero.next.pre = newHero;
        }
    }

    public void deleteList(int no) {
        HeroNode2 temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp=temp.next;
        }

        if(flag){
            throw new SysException(ExceptionEnum.ELEMENT_NOT_EXIST);
        }else{

        }
    }

    public void editList(HeroNode newHero) {

    }

    public int listLength(HeroNode head) {
        return 0;
    }

    public HeroNode2 getHeroByLast(DoubleLinkedList list, int no) {
        return null;
    }

    public void showList() {

    }

    public void reverseList(HeroNode head) {

    }

    public void reversePrint(DoubleLinkedList linkedList) {

    }
}

class HeroNode2{
    int no;
    String name;
    String nickName;
    HeroNode2 next;
    HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}