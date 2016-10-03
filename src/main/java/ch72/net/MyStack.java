package ch72.net;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by tie302954 on 2016/10/03.
 */
public class MyStack {

    private Object stack[];
    private int size;
    private int pointer;

    private static final int DEFAULT_STACK_SIZE = 100;

    public MyStack() {
        this(DEFAULT_STACK_SIZE);
    }

    public MyStack(int size) {
        stack = new Object[size];
        this.size = size;
        pointer = 0;
    }

    public void clear() {
        Arrays.fill(stack, 0, pointer, null);
        pointer = 0;
    }

    public void push(Object obj) {
        if (pointer == size) {
            throw new IllegalStateException("stack is over.");
        }
        stack[pointer++] = obj;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object val = stack[--pointer];
        stack[pointer] = null;
        return val;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public String toString() {
        String s = "MyStack=[";
        for (int i = 0; i < pointer; i++) {
            s = s + stack[i];
            if (i < pointer - 1) {
                s = s + ",";
            }
        }
        s = s +"]";
        return s;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
        System.out.println("stack pop : " + stack.pop());
        stack.clear();
        stack.push("d");
        stack.push("e");
        stack.push("f");
        while (!stack.isEmpty()) {
            System.out.println("stack pop : " + stack.pop());
        }
        System.out.println("stack empty.");

    }
}
