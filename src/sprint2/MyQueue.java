package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class MyQueue {
    private List<Integer> myQueue;
    private int size;

    public MyQueue() {
        myQueue = new LinkedList<>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer get() {
        Integer x = myQueue.get(0);
        myQueue.remove(0);
        size--;
        return x;
    }

    public void put(int x) {
        myQueue.add(x);
        size++;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            MyQueue myQueue = new MyQueue();
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if (command.contains("put")) {
                    String[] numberString = command.split(" ");
                    Integer number = Integer.parseInt(String.join("", numberString[1]));
                    myQueue.put(number);
                }
                if (command.equals("get")) {
                    if (myQueue.isEmpty()) {
                        System.out.println("error");
                    } else {
                        System.out.println(myQueue.get());
                    }
                }
                if (command.equals("size")) {
                    System.out.println(myQueue.size());
                }
            }
        }
    }
}
