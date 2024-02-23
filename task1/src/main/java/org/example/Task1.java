package main.java.org.example;

import java.io.IOException;

public class Task1 {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int position = 1;
        StringBuilder result = new StringBuilder();
        do {
            result.append(position);
            if (position + m - 1 <= n) {
                position = position + m - 1;
            } else {
                position = position + m - 1 - n;
            }
        } while (position != 1);

        System.out.println(result);
    }
}
