package org.datastructure.firstday.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNonation {
    public static void main(String[] args) {
        String expression = "3 4 + 5 * 6 -";

        List<String> list = getList(expression);
        int res = calculate(list);

        System.out.println(res);

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
