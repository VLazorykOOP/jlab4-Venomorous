import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        File directory = new File("Files");
        if (!directory.exists()) {
            directory.mkdir();
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        System.out.println("File name: " + file);

                        int count = 0;
                        int character;
                        while ((character = reader.read()) != -1) {
                            char ch = (char) character;
                            System.out.print(ch);
                            if (ch != ' ' && ch != '\r' && ch != '\n' && ch != '\t') {
                                count++;
                            }
                        }
                        System.out.println("");

//                        String line = reader.readLine();
//                        while (line != null) {
//                            System.out.println(line);
//                            line = reader.readLine();
//                        }

                        System.out.println("Symbols in a file: " + count);
                        System.out.println("");

                        reader.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading file: " + file.getName() + ". " + e.getMessage());
                    }
                }
            }
        }
    }
}
