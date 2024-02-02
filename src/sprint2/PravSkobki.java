package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class PravSkobki {
    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();
        boolean isCorrect = true;
        boolean answer = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] subsequence = reader.readLine().toCharArray();
            for (char c : subsequence) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    isCorrect = checkIfEquals(c, stack);
                }
                if (!isCorrect) {
                    answer = false;
                }
            }
            if (answer && checkIfStackIsEmpty(stack)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    private static boolean checkIfEquals(char item, Stack stack) {
        if (stack.getSize() > 0) {
            char element = stack.pop();
            if (item == ')' && element == '(') {
                return true;
            }
            if (item == '}' && element == '{') {
                return true;
            }
            if (item == ']' && element == '[') {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfStackIsEmpty(Stack stack) {
        return stack.getSize() == 0;
    }
}

class Stack {
    private List<Character> items;
    private int size;

    public Stack() {
        items = new LinkedList<>();
        size = 0;
    }

    public void push(Character item) {
        items.add(0, item);
        size++;
    }

    public Character pop() {
        size--;
        return items.remove(0);
    }

    public int getSize() {
        return size;
    }
}