package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str = reader.readLine();
        String[] nums = str.split(" ");
        double centreX = Double.parseDouble(nums[0]);
        double centreY = Double.parseDouble(nums[1]);
        str = reader.readLine();
        double r = Double.parseDouble(str);

        List<Double[]> xy = new ArrayList<>();
        reader = new BufferedReader(new FileReader(args[1]));
        while (true) {
            str = reader.readLine();
            if (str == null) {
                break;
            }
            nums = str.split(" ");
            Double[] temp = new Double[2];
            temp[0] = Double.parseDouble(nums[0]);
            temp[1] = Double.parseDouble(nums[1]);
            xy.add(temp);
        }

        for (int i = 0; i < xy.size(); i++) {
            double d = Math.sqrt((xy.get(i)[0] - centreX) * (xy.get(i)[0] - centreX)
                    + (xy.get(i)[1] - centreY) * (xy.get(i)[1] - centreY));
            if (d<r){
                System.out.println(1);
            } else if (d == r) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }
    }
}