import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        File input = new File("Input.txt");
        File integerOutput = new File("IntegerOutput.txt");
        File floatOutput = new File("FloatOutput.txt");
        try {
            if (!input.exists()) {
                input.createNewFile();
            }
            if (!integerOutput.exists()) {
                integerOutput.createNewFile();
            }
            if (!floatOutput.exists()) {
                floatOutput.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating file: " + e.getMessage());
            System.exit(1);
        }

        List<Integer> integers = new ArrayList<>();
        List<Float> floats = new ArrayList<>();

        float floatSum = 0;
        int intProduct = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int integer = Integer.parseInt(line);
                    integers.add(integer);
                    intProduct *= integer;
                } catch (NumberFormatException e1) {
                    try {
                        float floatNumber = Float.parseFloat(line);
                        floats.add(floatNumber);
                        floatSum += floatNumber;
                    } catch (NumberFormatException e2) {}
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading file: " + e.getMessage());
            System.exit(1);
        }

        Collections.sort(integers);
        Collections.sort(floats);

        try (BufferedWriter integerWriter = new BufferedWriter(new FileWriter(integerOutput));
             BufferedWriter floatWriter = new BufferedWriter(new FileWriter(floatOutput))) {
            for (Integer integer : integers) {
                integerWriter.write(Integer.toString(integer));
                integerWriter.newLine();
            }
            for (Float floatNumber:floats) {
                floatWriter.write(Float.toString(floatNumber));
                floatWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Sum of float numbers: " + floatSum);
        System.out.println("Product of integer numbers: " + intProduct);
    }
}