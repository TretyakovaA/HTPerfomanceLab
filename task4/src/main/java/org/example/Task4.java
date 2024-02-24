package main.java.org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        List<Integer> mass = new ArrayList<>();
        while (true) {
            String temp = reader.readLine();
            if (temp == null) {
                break;
            }
            mass.add(Integer.parseInt(temp));
        }

        OptionalDouble average = mass.stream().mapToInt(e -> e).average();
        int avg = (int) average.getAsDouble();
        int countSteps = 0;
        for (int i = 0; i < mass.size(); i++) {
            if (mass.get(i) > avg) {
                countSteps += mass.get(i) - avg;
            } else {
                countSteps += avg - mass.get(i);
            }
        }
        System.out.println(countSteps);
    }
}