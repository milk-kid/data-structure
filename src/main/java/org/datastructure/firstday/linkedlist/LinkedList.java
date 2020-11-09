package org.datastructure.firstday.linkedlist;

public interface LinkedList {
    HeroNode2 getHead();

    void addList(HeroNode2 newHero);

    void addByOrder(HeroNode2 hero);

    void deleteList(int no);

    void editList(HeroNode newHero);

    void showList();

    int listLength(HeroNode2 head);

    HeroNode2 getHeroByLast(LinkedList list, int lastIndex);
}
