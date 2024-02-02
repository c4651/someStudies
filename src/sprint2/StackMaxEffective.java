package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StackMaxEffective {
    private List<Integer> items;
    private int max = -100001;
    private List<Integer> maxItems;

    public StackMaxEffective() {
        items = new LinkedList<>();
        maxItems = new LinkedList<>();
    }

    public void push(Integer item) {
        items.add(0, item);
        if (max < item) {
            max = item;
            maxItems.add(0, max);
        }
    }

    public Integer pop() {
        if (items.get(0).equals(maxItems.get(0))) {
            maxItems.remove(0);
            if (maxItems.isEmpty()) {
                max = -100001;
            } else {
                max = maxItems.get(0);
            }
        }
        return items.remove(0);
    }

    public int get_max() {
        return maxItems.get(0);
    }

    public static void main(String[] args) throws IOException {
        StackMaxEffective stackMaxEffective = new StackMaxEffective();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if (command.contains("push")) {
                    String[] numberString = command.split(" ");
                    Integer number = Integer.parseInt(String.join("", numberString[1]));
                    stackMaxEffective.push(number);

                }
                if (command.equals("pop")) {
                    if (stackMaxEffective.items.isEmpty()) {
                        System.out.println("error");
                    } else {
                        stackMaxEffective.pop();
                    }
                }
                if (command.equals("get_max")) {
                    if (stackMaxEffective.items.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(stackMaxEffective.get_max());
                    }

                }
            }
        }
    }
}
