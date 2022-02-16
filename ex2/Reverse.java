package ex2;

import java.util.Stack;

public class Reverse {

    static Stack reverse(Stack stack) {// function reverse value in stack
        Stack<String> reverseStack = new Stack<>();
        while (!stack.empty()) {
            reverseStack.push(stack.pop().toString());
        }
        return reverseStack;
    }
}
