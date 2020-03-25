package com.company.linkedList;

public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private  Boy first = new Boy(-1);

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        if(nums < 1) {
            System.out.println("num incorrect");
            return;
        }

        //辅助指针，帮助构建环形链表
        Boy curBoy = null;

        //使用for构建环形链表
        for (int i = 1; i <= nums; i++) {
            //按照编号，构建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                //让curBoy指向第一个小孩
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                //形成环
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历
    public void showBoy() {
        if(first == null) {
            System.out.println("null");
            return;
        }

        //因为first不能动，所以仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("num: " + curBoy.getNo());
            if(curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入，计算小孩出圈的顺序
    //startNo:从第几个小孩开始数
    //countNum:数几下
    //nums:最初有几个小孩在圈中
    public void countBoy(int startNo, int countNum, int nums) {
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("input incorrect");
            return;
        }

        //创建辅助变量
        Boy helper = first;
        //让helper指向最后一个节点
        while (true) {
            if(helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //报数前，先让first和helper同时移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //报数时，让first和helper同时移动countNum-1次,然后出圈
        while (true) {
            //圈中只有一个节点
            if(helper == first) {
                break;
            }
            //让first和helper同时移动countNum - 1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点，就是要出圈的小小孩节点
            System.out.println("go out " + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的编号：" + first.getNo());

    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
