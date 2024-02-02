package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyQueueSized {
    private Integer[] queue;
    private int max_size;
    private int head;
    private int tail;
    private int size;

    public MyQueueSized(int max_size) {
        this.max_size = max_size;
        queue = new Integer[max_size];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(int x) {
        if (size != max_size) {
            queue[tail] = x;
            tail = (tail + 1) % max_size;
            size++;
        } else {
            System.out.println("error");
        }
    }

    public Integer pop() {
        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_size;
        size--;
        return x;
    }

    public Integer peek() {
        return queue[head];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            int max_size = Integer.parseInt(reader.readLine().strip());
            MyQueueSized myQueue = new MyQueueSized(max_size);
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if (command.contains("push")) {
                    String[] numberString = command.split(" ");
                    Integer number = Integer.parseInt(String.join("", numberString[1]));
                    myQueue.push(number);
                }
                if (command.equals("pop")) {
                    if (myQueue.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(myQueue.pop());
                    }
                }
                if (command.equals("peek")) {
                    if (myQueue.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(myQueue.peek());
                    }
                }
                if (command.equals("size")) {
                    System.out.println(myQueue.size());
                }
            }
        }
    }
}
