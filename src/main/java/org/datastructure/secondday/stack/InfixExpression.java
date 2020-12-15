package org.datastructure.secondday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class InfixExpression {

    public static void main(String[] args) {
        String expression = "13*7-5";
        int num1, num2, result, ch, index = 0;
        String keepNum = "";
        ArrayStack3 numStack = new ArrayStack3(10);
        ArrayStack3 operStack = new ArrayStack3(10);
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(numStack.cal(num1, num2, operStack.pop()));
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                keepNum += ch - 48;
                if (index >= expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
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
            numStack.push(numStack.cal(num1, num2, operStack.pop()));
            if (operStack.isEmpty()) {
                break;
            }
        }
        System.out.printf("experssion :%s = %d", expression, numStack.pop());
    }
}

class ArrayStack3 {
    int maxSize;
    int top = -1;
    int[] stack;

    public ArrayStack3(int masSize) {
        this.maxSize = masSize;
        stack = new int[masSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int no) {
        if (isFull()) {
            throw new SysException(ExceptionEnum.ELEMENT_FULL);
        }
        top++;
        stack[top] = no;
    }

    public int pop() {
        if (isEmpty()) throw new SysException(ExceptionEnum.ELEMENT_EMPTY);
        int temp = stack[top];
        top--;
        return temp;
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    public int peek() {
        return stack[top];
    }

    public int priority(int ch) {
        if ('*' == ch || '/' == ch) {
            return 1;
        } else if ('+' == ch || '-' == ch) {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(int ch) {
        return '*' == ch || '/' == ch || '+' == ch || '-' == ch;
    }

    public int cal(int num1, int num2, int oper) {
        int result;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}