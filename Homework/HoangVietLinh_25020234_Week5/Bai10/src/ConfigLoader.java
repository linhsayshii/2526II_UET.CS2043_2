import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class ConfigLoader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Đường dẫn file config: ");
        String filename = sc.nextLine();
        Map<String, String> config = new HashMap<>();
        BufferedReader bf = null;
        
        try {
            bf = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    config.put(parts[0].trim(), parts[1].trim());
                }
            }

            if (!config.containsKey("username")) {
                throw new InvalidConfigException("Invalid config: Thiếu username");
            }
            if (!config.containsKey("timeout")) {
                throw new InvalidConfigException("Invalid config: Thiếu timeout");
            }
            int timeout = Integer.parseInt(config.get("timeout"));
            if (timeout < 0) {
                throw new InvalidConfigException("Invalid config: Timeout phải là số không âm");
            }
            if (config.containsKey("maxConnections")) {
                int maxconnections = Integer.parseInt(config.get("maxConnections"));
                if (maxconnections <= 0) {
                    throw new InvalidConfigException("Invalid config: maxConnections phải là số dương");
                }
            }
            System.out.println("Config loaded successfully.");
            for (Map.Entry<String, String> entry : config.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format");
        } catch (InvalidConfigException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (bf != null) bf.close();
            } catch (IOException e) {
                System.err.println("I/O error.");
                e.printStackTrace();
            }
            sc.close();
            System.out.println("Program Finished");
        }
    }
}
