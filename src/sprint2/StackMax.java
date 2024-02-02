package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class StackMax {
    private List<Integer> items;

    public StackMax() {
        items = new ArrayList<>();
    }

    public void push(Integer item) {
        items.add(item);
    }

    public Integer pop() {
        return items.remove(items.size() - 1);
    }

    public int get_max() {
        Integer max = items.stream()
                .max(Comparator.naturalOrder())
                .get();
        return max;
    }

    public static void main(String[] args) throws IOException {
        StackMax stackMax = new StackMax();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if (command.contains("push")) {
                    String[] numberString = command.split(" ");
                    Integer number = Integer.parseInt(String.join("", numberString[1]));
                    stackMax.push(number);
                    // System.out.println(number);
                }
                if (command.equals("pop")) {
                    if (stackMax.items.isEmpty()) {
                        System.out.println("error");
                    } else {
                        stackMax.pop();
                    }
                }
                if (command.equals("get_max")) {
                    if (stackMax.items.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(stackMax.get_max());
                    }

                }
            }
        }
    }
}
