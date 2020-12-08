package org.datastructure.firstday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class InfixExpression {

    public static void main(String[] args) {
        String expression = "2+4-20";
        ArrayStack3 numStack = new ArrayStack3(10);
        ArrayStack3 operStack = new ArrayStack3(10);
        int index = 0;
        int num1;
        int num2;
        int ch;
        int result;
        String source = "";

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOperator(ch)) {
                if (!operStack.isEmpty()) {
                    if (numStack.priority(operStack.peek()) >= numStack.priority(ch)) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = numStack.calculate(num1, num2, operStack.pop());
                        numStack.push(result);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }

                } else {
                    operStack.push(ch);
                }
            } else {
                source += ch-48;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(source));
                } else {
                    if (operStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(source));
                        source = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            result = numStack.calculate(num1, num2, operStack.pop());
            numStack.push(result);
            if (operStack.isEmpty()) {
                break;
            }
        }

        System.out.printf("experssion:%s =%d", expression, numStack.pop());
    }
}


class ArrayStack3 {
    int maxSize;
    int[] stack;
    int top = -1;

    public ArrayStack3(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void showStack() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    public void push(int element) {
        if (isFull()) {
            throw new SysException(ExceptionEnum.ELEMENT_FULL);
        }
        top++;
        stack[top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * 查看栈顶
     *
     * @return
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 根据操作符确认其优先级
     *
     * @param ch 操作符
     * @return 返回优先级
     */
    public int priority(int ch) {
        if ('*' == ch || '/' == ch) {
            return 1;
        } else if ('+' == ch || '-' == ch) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断字符是不是操作符
     *
     * @param ch
     * @return
     */
    public boolean isOperator(int ch) {
        return '*' == ch || '/' == ch || '+' == ch || '-' == ch;
    }

    /**
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public int calculate(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {//todo 根据操作符计算结果
            case '+':
                result = num1 + num2;
                break;
            case '-'://todo 依据stack的特性先进后出特性，mun2先进后出
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/'://todo 同上
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}