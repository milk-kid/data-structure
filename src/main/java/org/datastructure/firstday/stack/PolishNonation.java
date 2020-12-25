package org.datastructure.firstday.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNonation {
    public static void main(String[] args) {
      /*  String expression = "3 4 + 5 * 6 -";

        List<String> list = getList(expression);
        int res = calculate(list);

        System.out.println(res);*/
        String expression = "3+(5+2)*4-2";
        List<String> infixExpression = toInfixExpression(expression);
        List<String> suff = toSuffixExpression(infixExpression);
        System.out.println(suff);
        int calculate = calculate(suff);
        System.out.println(calculate);
    }

    public static List<String> toSuffixExpression(List<String> infixExpression) {

        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        int index = 0;
        for (String str : infixExpression) {
            if (str.matches("\\d")) {
                s2.add(str);
            } else if (str.equals("(")) {
                s1.add(str);
            } else if (str.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while(s1.size()>0&&Operation.value(s1.peek())>=Operation.value(str)){
                     s2.add(s1.pop());
                }
                s1.push(str);
            }
        }

        while(s1.size()>0){
            s2.add(s1.pop());
        }

        return s2;
    }

    public static List<String> toInfixExpression(String s) {
        ArrayList<String> lists = new ArrayList<>();

        int index = 0;
        char c;
        String str = "";
        do {

            if ((c = s.charAt(index)) < 48 || (s.charAt(index)) > 57) {
                lists.add(c + "");
                index++;
            } else {
                str = "";
                while (index < s.length() && (c = s.charAt(index)) >= 48 && (s.charAt(index)) <= 57) {
                    str += c;
                    index++;
                }
                lists.add(str);
            }
        } while (index < s.length());


        return lists;
    }

    public static List<String> getList(String expression) {
        String[] split = expression.split(" ");
        ArrayList<String> ls = new ArrayList<>();
        for (String s : split) {
            ls.add(s);
        }
        return ls;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        int num1 = 0, num2 = 0;
        int res = 0;
        for (String ele : ls) {
            if (ele.matches("\\d+")) {
                stack.push(ele);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                if (ele.equals("+")) {
                    res = num1 + num2;
                } else if (ele.equals("-")) {
                    res = num2 - num1;
                } else if (ele.equals("*")) {
                    res = num1 * num2;
                } else if (ele.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("操作符不合法");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int value(String s) {
        int res = 0;
        switch (s) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
        }
        return res;
    }
}