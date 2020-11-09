package org.example;


import org.datastructure.firstday.linkedlist.LinkedListTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */

public class AppTest {


    @Test
    public void test2(){
        LinkedListTest listTest = new LinkedListTest();

        listTest.main(new String[]{"","",""});
        System.out.println("test run pass");
    }
}
