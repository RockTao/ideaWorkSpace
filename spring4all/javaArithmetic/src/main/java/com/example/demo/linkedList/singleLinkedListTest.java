package com.example.demo.linkedList;

import org.junit.jupiter.api.Test;

public class singleLinkedListTest {
    @Test
    public void testSingleLinkedList(){
        singleLinkedList singleList = new singleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
    }
}
