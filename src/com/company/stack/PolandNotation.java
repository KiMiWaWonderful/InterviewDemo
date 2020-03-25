package com.company.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    具体思路：
    1）初始化2个栈：运算符栈s1和储存中间结果的栈s2；
    2）从左至右扫描中缀表达式；
    3）遇到操作数时，将其压入s2；
    4）遇到运算符时，比较其与s1栈顶运算符的优先级：
        （1）如果s1为空，或栈顶运算符为“(”，则将此运算符入栈；
        （2）否则，若优先级比栈顶运算符的高，也将运算符压入s1；
        （3）否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与新的运算符比较。
    5）遇到括号时：
        （1）“(”：压入s1;
        （2）“)”：依次弹出s1栈顶的运算符，并压入s2，直到遇到“(”为止，此时将这一对括号丢弃；
    6）重复步骤2至5，直到表达式最右边；
    7）将s1中剩余的运算符依次弹出压入s2;
    8）依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
public class PolandNotation {

    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpreesionList = toInfixExpressionList(expression);
        System.out.println(infixExpreesionList);

        List<String> parseSuffixExpressionList = parseSuffixExpreesionList(infixExpreesionList);
        System.out.println(parseSuffixExpressionList);
        System.out.println(calculate(parseSuffixExpressionList));
        /*
//        String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";

        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList: " + rpnList);

        System.out.println(calculate(rpnList));
        */

    }

    //1.将中缀表达式转换成对应的List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List,存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        //用于遍历中缀表达式字符串
        int i = 0;
        //拼接多位数
        String str;
        //遍历一个字符就放入c
        char c;

        do{
            //如果c是一个非数字，需要加入到list
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add(c + "");
                i ++;
            }else {
                //如果是一个数，要考虑多位数

                //现将str置成""
                str = "";
                //'0'[48] '9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    //拼接
                    str += c;
                    i ++;
                }
                list.add(str);
            }
        }while ( i < s.length()) ;

        return list;
    }

    //2.将得到的中缀表达式对应的List =》 后缀表达式对应的List
    public static List<String> parseSuffixExpreesionList(List<String> list) {
        //符号栈
        Stack<String> s1 = new Stack<>();
        //因为s2在整个转换过程中，没有pop操作，而且后面还要逆向输出，因此不使用Stack而是List
        //储存中间结果的List
        List<String> s2 = new ArrayList<>();

        for (String item: list) {
            //如果是一个数
            if(item.matches("\\d+")) {
                s2.add(item);
            }else if(item.equals("(")) {
                s1.push(item);
            }else if(item.equals(")")) {
                //如果是)，则依次弹出s1栈顶的运算符，并压入s2,直到遇到(为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //将(弹出s1栈，消除小括号
                s1.pop();
            }else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到（4,1）与新的栈顶运算符比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele: split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式(后缀表达式)的运算
    /*
        1)从左至右扫描，将3和4压入堆栈；
        2）遇到+运算符，弹出3和4，计算3+4的值，得7，再将7入栈
        3）将5入栈
        4）接下来是×运算符，弹出5和7，计算7*5得35，将35入栈
        5）将6入栈
        6）最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item: list) {
            //使用正则表达式匹配多位数
            if(item.matches("\\d+")) {
                //入栈
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;

                if(item.equals("+")) {
                    res = num1 + num2;
                }else if(item.equals("-")) {
                    res = num1 - num2;
                }else if(item.equals("*")) {
                    res = num1 * num2;
                }else if(item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类，返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
