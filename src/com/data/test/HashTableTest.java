package com.data.test;

import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(7);
        Scanner scan = new Scanner(System.in);
        String key = "";
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 退出系统");
            System.out.println("exit: 退出系统");
            System.out.println("请输入");
            key = scan.next();
            switch (key){
                case "add":
                    System.out.println("请输入id:");
                    int id = scan.nextInt();
                    System.out.println("请输入名字:");
                    String name = scan.next();
                    Student student = new Student(id,name);
                    hashtable.add(student);
                    break;
                case "list":
                    hashtable.list();
                    break;
                case "find":
                    System.out.println("请输入id:");
                    id = scan.nextInt();
                    hashtable.find(id);
                    break;
                case "delete":
                    System.out.println("请输入id:");
                    id = scan.nextInt();
                    hashtable.del(id);
                    break;
                case "exit":
                    System.out.println("程序退出~");
                    break;
                default:
                    break;
            }
        }
    }
}

class Hashtable{

    private int size;
    private StuLinkedList[] stus;

    public Hashtable(int size){
        this.size = size;
        stus = new StuLinkedList[size];
        for(int i = 0; i<size;i++){
            stus[i] = new StuLinkedList();
        }
    }

    public void add(Student stu){
        int hashcodeNo = hashcode(stu.id);
        stus[hashcodeNo].add(stu);
    }

    public void list(){
        for (int i = 0;i<size;i++){
            stus[i].list(i);
        }
    }

    public void find(int id){
        int hashcodeNo = hashcode(id);
        stus[hashcodeNo].findById(id);
    }

    public void del(int id){
        int hashcodeNo = hashcode(id);
        stus[hashcodeNo].delById(id);
    }

    public int hashcode(int id){
        return id % size;
    }

}


class Student{
    public int id;
    public String name;
    public Student next;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class StuLinkedList{
    Student head = new Student(0,"");

    public void add(Student stu){

        Student cur = head;

        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = stu;

    }

    public void list(int id){
        if(head.next == null){
            System.out.println("第"+(id+1)+"条链表为空");
            return;
        }
        Student cur = head;
        System.out.println("第"+(id+1)+"条链表为");
        while(cur.next!=null){
            System.out.print(cur.next+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void findById(int id){
        if(head.next == null){
            System.out.println("哈希表中不存在id="+id+"的数据");
            return;
        }
        Student cur = head;
        boolean flag = true;
        while(cur.next!=null){
            if(cur.next.id == id){
                System.out.println(cur.next);
                flag = false;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            System.out.println("链表中不存在id="+id+"的数据");
        }
    }
    public void delById(int id){
        if(head.next == null){
            System.out.println("哈希表中不存在id="+id+"的数据");
            return;
        }
        Student cur = head;
        boolean flag = true;
        while(cur.next!=null){
            if(cur.next.id == id){
                Student del = cur.next;
                cur.next = cur.next.next;
                System.out.println("删除的数据为"+del);
                flag = false;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            System.out.println("哈希表中不存在id="+id+"的数据");
        }
    }


}
