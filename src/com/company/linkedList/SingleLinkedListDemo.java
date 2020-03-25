package com.company.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"1","1");
        HeroNode heroNode2 = new HeroNode(2,"2","2");
        HeroNode heroNode3 = new HeroNode(3,"3","3");
        HeroNode heroNode4 = new HeroNode(4,"4","4");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        //加入
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        //按照编号加入
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.list();

        System.out.println();

        //修改
        HeroNode newNode = new HeroNode(2, "22", "22");
        singleLinkedList.update(newNode);

        singleLinkedList.list();

        singleLinkedList.del(1);
        System.out.println();
        singleLinkedList.list();

        //测试单链表的节点的个数
        System.out.println(getLength(singleLinkedList.getHead()));

        //测试查找单链表中倒数第K个节点
        System.out.println(findLastIndexNode(singleLinkedList.getHead(),1));

        System.out.println();

        //测试翻转
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println();

        //测试逆序打印
        reversePrint(singleLinkedList.getHead());


    }

    //获取到单链表的节点的个数（如果是带头节点的链表，不统计节点）
    public static int getLength(HeroNode head) {
        //空链表
        if(head.next == null) {
            return 0;
        }

        int length = 0;

        //定义一个辅助的变量
        HeroNode cur = head.next;
        while (cur != null) {
            length ++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中倒数第K个节点
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index表示倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总长度（getLength）
    // 4.得到size后，从链表的第一个开始遍历（size-index）个,就可以得到
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if(head.next == null) {
            return null;
        }

        //第一次遍历得到链表长度
        int size = getLength(head);

        //第二次遍历size-index位置，就是我们倒数的第K个节点
        if(index <= 0 || index > size) {
            return null;
        }

        //定义辅助的变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }

        return cur;
    }

    //将单链表反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助的变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            //暂时保存当前节点的下一个节点
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur连接到新的链表上
            reverseHead.next = cur;
            //让cur后移
            cur = next;
        }

        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;

    }

    //逆序打印
    //利用栈先进后出的特点
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出while时候,temp就指向了链表的最后,指向新的node
        temp.next = heroNode;
    }

    //根据序号将node插入到指定位置
    public void addByOrder(HeroNode heroNode) {
        //头节点不能动，所以要一个辅助变量来遍历
        HeroNode temp = head;
        //标识添加的编号是否存在
        boolean flag = false;

        //遍历链表，找到最后
        while (true) {
            if(temp.next == null) {
                break;
            }

            //找到位置， 在temp后面插入
            if(temp.next.no > heroNode.no) {
                break;
            }else if(temp.next.no == heroNode.no) {//希望添加的node的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag的值
        if(flag) {//不能添加，说明编号存在
            System.out.println(heroNode.no + " cun zai");
        }else {
            //插入到链表中,temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息，根据编号来改正，但编号不能改正
    public void update(HeroNode newHeroNode) {
        if(head.next == null) {
            System.out.println("LinkedList is null~~");
            return;
        }

        //定义一个辅助变量
        HeroNode temp = head.next;
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
    public void del(int no) {
        HeroNode temp = head;
        //标识是否找到节点
        boolean flag = false;
        while (true) {
            if(temp.next == null) {
                break;
            }

            //找到待删除节点的前一个节点temp
            if(temp.next.no == no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
        }else {
            System.out.println("bu cun zai " + no);
        }
    }

    public void list() {
        if(head.next == null) {
            System.out.println("null");
            return;
        }

        //头节点不能动，所以要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
