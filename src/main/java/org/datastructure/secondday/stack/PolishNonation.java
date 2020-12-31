package org.datastructure.secondday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

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

        String expression = "3+52/(4+1)";


    }

    public static List<String> toInfixExpression(String s) {
        return null;
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
            if (str.matches("\\d")) {
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
