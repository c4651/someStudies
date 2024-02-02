package sprint2;
//Наивное решение
//Оптимальное решение
//Доказательство корректности
//Асимптотика

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyDeque {
    private Integer[] deque;
    private int max_n;
    private int front;
    private int back;
    private int size;


    public MyDeque(int n) {
        deque = new Integer[n];
        max_n = n;
        front = 0;
        back = 0;
        size = 0;
    }


    public StringBuilder push_front(int x) {
        if (size != max_n) {
            front = (front - 1 + max_n) % max_n;
            deque[front] = x;
            size++;
            return new StringBuilder();
        } else {
            return new StringBuilder("error\n");
        }
    }

    public StringBuilder push_back(int x) {
        if (size != max_n) {
            deque[back] = x;
            back = (back + 1) % max_n;
            size++;
            return new StringBuilder();
        } else {
            return new StringBuilder("error\n");
        }
    }

    public Integer pop_front() {
        if (size > 0) {
            Integer x = deque[front];
            front = (front + 1) % max_n;
            size--;
            return x;
        } else {
            return null;
        }
    }

    public Integer pop_back() {
        if (size > 0) {
            back = (back - 1 + max_n) % max_n;
            size--;
            return deque[back];
        } else {
            return null;
        }
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            int max_size = Integer.parseInt(reader.readLine().strip());
            MyDeque myDeque = new MyDeque(max_size);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if (command.contains("push_front")) {
                    String[] numberString = command.split(" ");
                    int number = Integer.parseInt(numberString[1]);
                    answer.append(myDeque.push_front(number));
                } else if (command.contains("push_back")) {
                    String[] numberString = command.split(" ");
                    int number = Integer.parseInt(numberString[1]);
                    answer.append(myDeque.push_back(number));
                } else if (command.equals("pop_front")) {
                    Integer x = myDeque.pop_front();
                    if (x != null) {
                        answer.append(x).append("\n");
                    } else {
                        answer.append("error\n");
                    }
                } else if (command.equals("pop_back")) {
                    Integer x = myDeque.pop_back();
                    if (x != null) {
                        answer.append(x).append("\n");
                    } else {
                        answer.append("error\n");
                    }
                }
            }
            writer.write(String.valueOf(answer));
            writer.flush();
        }
    }
}