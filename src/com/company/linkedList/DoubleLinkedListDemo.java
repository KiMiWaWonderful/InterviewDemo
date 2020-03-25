package com.company.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1,"1","1");
        HeroNode2 heroNode2 = new HeroNode2(2,"2","2");
        HeroNode2 heroNode3 = new HeroNode2(3,"3","3");
        HeroNode2 heroNode4 = new HeroNode2(4,"4","4");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode2 = new HeroNode2(4,"44","44");
        doubleLinkedList.update(newHeroNode2);
        System.out.println();
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(1);
        System.out.println();
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead() {
        return head;
    }

    //添加到链表最后
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出while时候,temp就指向了链表的最后,指向新的node
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改节点信息，根据编号来改正，但编号不能改正
    //双向链表修改和单链表一样
    public void update(HeroNode2 newHeroNode) {
        if(head.next == null) {
            System.out.println("LinkedList is null~~");
            return;
        }

        //定义一个辅助变量
        HeroNode2 temp = head.next;
        //是否找到要修改的变量
        boolean flag = false;

        while (true) {
            //已经遍历完链表
            if(temp == null) {
                break;
            }

            if(temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }

            temp = temp.next;
        }

        //根据flag判断是否找到要修改的node
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("no find " + newHeroNode.no);
        }
    }

    //删除节点
    //对于双向链表，可以直接找到要删除的节点，自我删除即可
    public void del(int no) {
        if(head.next == null) {
            System.out.println("null");
            return;
        }

        //辅助变量
        HeroNode2 temp = head.next;
        //标识是否找到节点
        boolean flag = false;
        while (true) {
            if(temp == null) {
                break;
            }

            //找到待删除节点的前一个节点temp
            if(temp.no == no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag) {
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else {
            System.out.println("bu cun zai " + no);
        }
    }

    //遍历
    public void list() {
        if(head.next == null) {
            System.out.println("null");
            return;
        }

        //头节点不能动，所以要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
