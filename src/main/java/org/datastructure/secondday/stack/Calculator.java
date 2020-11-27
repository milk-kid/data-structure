package org.datastructure.secondday.stack;

import org.datastructure.exception.ExceptionEnum;
import org.datastructure.exception.SysException;

public class Calculator {
    public static void main(String[] args) {
        String expression = "1+6*2-8";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1;
        int num2;
        int result;
        int ch;
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                   if(operStack.priority(operStack.peek())>=operStack.priority(ch)){
                       num1 = numStack.pop();
                       num2 = numStack.pop();
                       result = numStack.cal(num1,num2,operStack.pop());
                       numStack.push(result);
                       operStack.push(ch);
                   }else{
                       operStack.push(ch);
                   }
                }else{
                    operStack.push(ch);
                }
            }else{
                numStack.push(ch-48);
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }

        while(true){
            num1 = numStack.pop();
            num2= numStack.pop();
            result = numStack.cal(num1,num2,operStack.pop());
            numStack.push(result);
            if(operStack.isEmpty()){
                break;
            }
        }

        System.out.printf("experssion:%s = %d", expression,numStack.pop());
    }
}

class ArrayStack2 {
    int maxSize;
    int top = -1;
    int[] stack;

    public ArrayStack2(int masSize) {
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

