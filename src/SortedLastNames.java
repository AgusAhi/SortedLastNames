import java.io.*;
import java.util.*;
public class SortedLastNames {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = readCSV();
        WriteCSV(map);
    }

    private static void WriteCSV(Map<String, Integer> map) throws IOException {
        PrintWriter out = null;
        Set<String> keys = map.keySet();
        try {
            out = new PrintWriter(new FileWriter("sorted.txt"));
            for (String key: keys) {
                Integer value = map.get(key);
                out.println(key + ',' + value);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static Map<String, Integer> readCSV() throws IOException {
        BufferedReader input = null;
        Map<String, Integer> map = new TreeMap<>();
        try {
            input = new BufferedReader(new FileReader("LastnameFrequencies.csv"));
            String line;
            while ((line = input.readLine()) != null) {
                String [] items = line.split(",");
                String lastName = items[0];
                String freqStr = items[1].replaceAll("\\.","");
                Integer freq = Integer.parseInt(freqStr);
                map.put(lastName, freq);
            }
            return map;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

}
