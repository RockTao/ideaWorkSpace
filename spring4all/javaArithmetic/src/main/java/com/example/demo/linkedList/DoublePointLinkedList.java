package com.example.demo.linkedList;

public class DoublePointLinkedList {
    private  Node head;
    private Node tail;
    private int size;
    private class Node{
        private Object data;
        private Node next;
        public Node(Object data){
            this.data = data;
        }
    }

 public  DoublePointLinkedList(){
        head = null;
        tail = null;
        size= 0;
 }
    //链表头新增节点
    public void addHead(Object data){
        Node node = new Node(data);
        if(size == 0){//如果链表为空，那么头节点和尾节点都是该新增节点
            head = node ;
            tail = node;
            size ++;
        }else {
            node.next = head;
            head = node;
            size ++;
        }
    }
    //链表尾新增节点
    public void addTail(Object data){
        Node node = new Node(data);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            tail.next = node;
            tail= node;
            size ++;
        }
    }
    //删除头部节点，成功返回true，失败返回false
    public boolean deleteHead(){
        if(size == 0){ //当前链表节点数为0
            return  false;
        }
        if(head.next == null){
            head = null;
            tail = null;
        }else {
            head = head.next;
        }
        size --;
        return true;
    }
    //判断是否为空
    public boolean isEmpty(){
        return (size == 0);
    }
    //获得链表的节点个数
    public int getSize(){
        return  size;
    }
    // //显示节点信息
    public void display(){
        if(size > 0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){
                System.out.println("["+ node.data +"]");
                return;
            }
            while (tempSize > 0){
                if(node.equals(head)){
                    System.out.print("["+node.data + "->");
                }else  if(node.next == null){
                    System.out.printf(node.data +"]");
                }else {
                    System.out.printf(node.data +"->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else {
            System.out.println("]");
        }
    }

}

