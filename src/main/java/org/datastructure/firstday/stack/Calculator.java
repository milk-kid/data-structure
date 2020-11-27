package org.datastructure.firstday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class Calculator {
    public static void main(String[] args) {
        String expression = "5+2*3-3-7*1";
        //todo 创建两个栈，数栈/符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //todo 定义需要的相关变量
        int index = 0;
        int ch;
        int num1;
        int num2;
        int result;
        //todo 开始while循环扫描expression
        while (true) {
            //todo 依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //todo 判断ch是什么，然后做响应处理
            if (operStack.isOperator(ch)) {
                //todo 判断当前符号栈是否为空，
                if (!operStack.isEmpty()) {
                    //todo 如果符号栈有操作符，就进行比较priority，如果当前操作符小于或等于栈定操作符，就需要从数栈pop出两个数
                    //todo 再从符号栈pop出一个操作符进行运算，将结果入数栈，然后将当前符号入符号栈
                    if (operStack.priority(operStack.peek()) >= operStack.priority(ch)) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = operStack.calculate(num1, num2, operStack.pop());
                        numStack.push(result);
                        operStack.push(ch);
                    } else {
                        //todo 当前符号大于符号栈定符号，直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    //todo 如果符号栈为空，当前符号入符号栈
                    operStack.push(ch);
                }
            } else {
                //todo 如果当前字符为数值，入数栈
                numStack.push(ch - 48);
            }
            //todo 索引+1
            index++;
            //todo 如果index 大于或等于当前表达式长度，退出while循环
            if (index >= expression.length()) {
                break;
            }
        }

        //todo 计算数栈剩余数
        while (true) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            result = numStack.calculate(num1, num2, operStack.pop());
            numStack.push(result);
            //todo 符号栈为空，判定计算完成，推出while循环
            if (operStack.isEmpty()) {
                break;
            }
        }
        System.out.printf("expression : %s = %d", expression, numStack.pop());
    }
}

/**
 * 使用数组模拟栈
 */
class ArrayStack2 {
    int maxSize;
    int[] stack;
    int top = -1;

    public ArrayStack2(int maxSize) {
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
