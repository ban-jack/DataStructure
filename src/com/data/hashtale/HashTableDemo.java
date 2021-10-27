package com.data.hashtale;

import java.util.Scanner;


public class HashTableDemo {
    public static void main(String[] args) {
        //hashtable的长度可以自定义
        Hashtable hashtable = new Hashtable(7);
        String key = "";
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 退出系统");
            System.out.println("exit: 退出系统");
            key=scan.next();
            switch (key){
                case "add":
                    System.out.println("输入 id");
                    int id = scan.nextInt();
                    System.out.println("输入名字");
                    String name = scan.next();
//创建 雇员
                    Emp emp = new Emp(id, name);
                    hashtable.addEmp(emp);
                    break;
                case "list":
                    hashtable.listEmp();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scan.nextInt();
                    hashtable.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("请输入要删除的id");
                    id =scan.nextInt();
                    hashtable.delEmpById(id);
                    break;
                case "exit":
                    scan.close();
                    System.exit(0);
                default:
                    break;
                    
            }
        }
    }
}

//创建 HashTab 管理多条链表
class Hashtable{
    public  int size;
    public EmpLinkedList[] empLinkedListArr;
    public Hashtable(int size) {
        this.size = size;
        empLinkedListArr =new EmpLinkedList[size];//默认为null
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    public void addEmp(Emp emp){
        int hashcodeNo = hashcode(emp.id);
        empLinkedListArr[hashcodeNo].add(emp);
    }

    public void listEmp(){
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list(i);
        }
    }
    public void findEmpById(int id){
        int hashcodeNo = hashcode(id);
        empLinkedListArr[hashcodeNo].findById(id,hashcodeNo);
    }
    public void delEmpById(int id){
        int hashcodeNo = hashcode(id);
        empLinkedListArr[hashcodeNo].delById(id);
    }

    //编写散列函数, 使用一个简单取模法
    //使用的id就会按算法存在相应的链表中
    public int hashcode(int id){
        return id %  size;
    }


}
//表示一个员工
class Emp {

    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
//创建 EmpLinkedList ,表示链表
class EmpLinkedList{

    /*
    注意这里的头指针不含有值
    也可以创建一个头指针含有第一个emp
    相应的遍历方法即要发生改变
     */
    private Emp head= new Emp(0,"");//头节点


    public void add(Emp emp){

        Emp cur = head;
        
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next = emp;

    }

    public void list(int id){
        if(head.next==null){//说明这条链表为空
            System.out.println("第"+(id+1)+"链表为空");
            return;
        }
        Emp cur = head;
        System.out.print("第"+(id+1)+"链表为");
        while(cur.next!=null){
            System.out.print(cur.next+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    public void findById(int id,int hashcodeNo){
        if(head.next==null){
            System.out.println("哈希表中不存在id="+id+"的数据");
            return;
        }
        Emp cur = head.next;
        boolean flag = false;
        while(cur!=null){
            if(cur.id == id){
                System.out.println("在第"+(hashcodeNo+1)+"条链表中找到员工值为"+cur);
                flag = true;
                break;
            }
            cur=cur.next;
        }
        if(!flag){
            System.out.println("没有找到链表中对应的员工信息");
        }
    }

    public void delById(int id){
        if(head.next==null){
            System.out.println("哈希表中不存在id="+id+"的数据");
            return;
        }
        Emp cur = head;
        boolean flag = false;
        while(cur.next!=null){
            if(cur.next.id == id){
                flag = true;
                break;
            }
            cur=cur.next;
        }
        if (flag){
            Emp del = cur.next;
            cur.next = cur.next.next;
            System.out.println("删除成功！删除数据是："+del);
        }else{
            System.out.println("没有找到第"+(id+1)+"条链表中对应的员工信息");
        }
    }

}
