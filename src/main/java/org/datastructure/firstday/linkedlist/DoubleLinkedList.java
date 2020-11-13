package org.datastructure.firstday.linkedlist;

class DoubleLinkedList implements LinkedList {
    private HeroNode2 head = new HeroNode2(1, "", "");

    @Override
    public HeroNode2 getHead() {
        return head;
    }

    @Override
    public void addList(HeroNode2 newHero) {
        HeroNode2 temp = this.head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = newHero;
        newHero.pre = temp;
    }

    @Override
    public void addByOrder(HeroNode2 hero) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            hero.next = temp.next;
            temp.next = hero;
            hero.pre = temp;
            hero.next.pre = hero;
        } else {
            temp.next = hero;
            hero.pre = temp;
        }
    }

    @Override
    public void deleteList(int no) {
        HeroNode2 temp = head;
        if (temp.next == null) return;

        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (no == temp.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            //这里如果temp如果是最后一个节点，那么temp.next就会报空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("该英雄不存在！");
        }
    }

    @Override
    public void editList(HeroNode newHero) {

        if (head.next == null) return;
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHero.name;
            temp.nickName = newHero.nickName;
        } else {
            System.out.println("此英雄不存在！");
        }
    }

    @Override
    public void showList() {
        if (head.next == null) return;
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    @Override
    public int listLength(HeroNode2 head) {
        if (head.next == null) return 0;
        HeroNode2 temp = head;
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

    @Override
    public HeroNode2 getHeroByLast(LinkedList list, int lastIndex) {
        if (list.getHead().next == null) {
            return null;
        }
        int length = list.listLength(list.getHead());
        if (lastIndex <= 0 || lastIndex > length) {
            return null;
        }

        HeroNode2 temp = head.next;
        for (int i = 0; i < length - lastIndex; i++) {
            temp = temp.next;
        }
        return temp;
    }

}

class HeroNode2 {
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