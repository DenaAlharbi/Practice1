import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String FILE_NAME = "C:\\Users\\denaa\\JavaProjects231\\practice1\\src\\data.txt",FILE_NAME1 = "C:\\Users\\denaa\\JavaProjects231\\practice1\\src\\output.txt";
        ArrayList<String> lines = new ArrayList<>();
        Map<String, String[]> sortedMap = new TreeMap<>();

        try (Scanner input = new Scanner(new File(FILE_NAME))) {
            while (input.hasNextLine()) {
                while (input.hasNextLine()) {
                    String New = input.nextLine();
                    System.out.println(New);
                    lines.add(New);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.format("File not found: %s%n", FILE_NAME);
        }
        for (String line : lines) {
            String[] splitter = line.split(" ");
            System.out.println(Arrays.toString(splitter));

            String[] arr = {};
            sortedMap.put(splitter[1],sortedMap.getOrDefault(splitter[1],arr));

            String[] array = sortedMap.get(splitter[1]);
            String[] newArray = Arrays.copyOf(array, array.length + 1);
            newArray[newArray.length - 1] = splitter[0];
            sortedMap.put(splitter[1],newArray);

        }

        PrintWriter write;
        try {
            new FileWriter(FILE_NAME1, false).close();
            write = new PrintWriter(new FileWriter(FILE_NAME1, true));
            for (Map.Entry<String, String[]> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                String[] value = entry.getValue();
                write.println(key + "\n " + Arrays.toString(value));
            }

            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}