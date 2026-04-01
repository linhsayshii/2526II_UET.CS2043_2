import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ghi tệp
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("../numbers.dat"));
            System.out.print("Nhập các số (cách nhau bởi space): ");
            String line = sc.nextLine();
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                try {
                    dos.writeInt(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                    System.err.println("Số không hợp lệ: " + number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
            System.out.println("Write file finished");
        }

        System.out.println("--------------------------------");

        //Đọc tệp
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("../numbers.dat"));
            while (true) {
                try{
                    int number = dis.readInt();
                    System.out.println(number);
                } catch (EOFException e){
                    break;
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Read file finished");
            }
        }
    }
}