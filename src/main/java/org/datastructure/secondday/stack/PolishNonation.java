package org.datastructure.secondday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolishNonation {
    public static void main(String[] args) {
     /*   String expression = "3 4 + 5 * 2 -";

        List<String> strings = getList(expression);
        System.out.println(strings);
        int res = calculate(strings);
        System.out.println(res);*/

        String expression = "3+52*(4+1)";
        List<String> infix = toInfixExpression(expression);
        System.out.println(infix);

        List<String> suffix = toSuffixExpression(infix);
        System.out.println(suffix);
        System.out.println(calculate(suffix));
        System.out.println();

    }

    public static List<String> toSuffixExpression(List<String> lists) {
        String keepNum = "";
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : lists) {
            if (item.matches("\\d*")) {
                s2.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                while (!("(").equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                keepNum = "";
                while (s1.size() > 0 && Operation.value(s1.peek()) >= Operation.value(item)) {
                    keepNum += item;
                }
                s1.push(item);
            }
        }

        while (s1.size() > 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    public static List<String> toInfixExpression(String s) {
        int index = 0;
        char c;
        String keepNum = "";
        ArrayList<String> lists = new ArrayList<>();
        do {
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
                lists.add(c + "");
                index++;
            } else {
                keepNum = "";
                while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
                    keepNum += c;
                    index++;
                }
                lists.add(keepNum);
            }
        } while (index < s.length());
        return lists;
    }

    public static List<String> getList(String expression) {
        String[] lists = expression.split(" ");
        List<String> strings = Arrays.asList(lists);
        return strings;
    }

    public static int calculate(List<String> strings) {

        Stack<String> stack = new Stack<>();
        int num1;
        int num2;
        int res = 0;
        for (String str : strings) {
            if (str.matches("\\d*")) {
                stack.push(str);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                switch (str) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new SysException(ExceptionEnum.ELEMENT_NOT_EXIST);
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